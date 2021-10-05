package system.logic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import system.libs.Formulas;

@XmlAccessorType(XmlAccessType.FIELD)
public class Loan {
    int term;
    double amount;
    double interestRate;
    double monthlyFee;
    boolean active;
    Date date;
    List<MonthlyPayment> monthlyPayments;
    List<Double> extraordinaryPayments;

    public Loan(int term, double amount, double interestRate, Date date) {
        this.term = term;
        this.amount = amount;
        this.interestRate = interestRate;
        this.monthlyFee = Formulas.monthlyFee(term, amount, interestRate);
        this.active = true;
        this.date = date;
        this.monthlyPayments = getMonthlyPaymentList();
        this.extraordinaryPayments = new ArrayList<>();
    }
    
    public Loan() {
        this.term = 0;
        this.amount = 0.0;
        this.interestRate = 0.0;
        this.monthlyFee = 0.0;
        this.active = false;
        this.date = null;
        this.monthlyPayments = null;
        this.extraordinaryPayments = null;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<MonthlyPayment> getMonthlyPayments() {
        return monthlyPayments;
    }

    public void setMonthlyPayments(List<MonthlyPayment> monthlyPayments) {
        this.monthlyPayments = monthlyPayments;
    }

    public List<Double> getExtraordinaryPayments() {
        return extraordinaryPayments;
    }

    public void setExtraordinaryPayments(List<Double> extraordinaryPayments) {
        this.extraordinaryPayments = extraordinaryPayments;
    }
    
    public int getExtraordinaryPaymentsSize() {
        if (extraordinaryPayments != null) {
            return extraordinaryPayments.size();
        }
        
        return 0;
    }
    
    private int generateTerm() {
        int total = 0;
        MonthlyPayment mp;
        
        for (int i = 0; i < monthlyPayments.size(); i++) {
            mp = monthlyPayments.get(i);
            if(!mp.isPaid()) {
                total++;
            }
        }
        
        return total;
    }
    
    private List<MonthlyPayment> getMonthlyPaymentList() {
        List<MonthlyPayment> result = new ArrayList<>();
        MonthlyPayment monthlyPayment = null;
        Date tempDate = date;
        double tempAmount = amount;
        double tempInterestRate;
        double tempAmortization = 0.0;
        for (int i = 0; i < term; i++) {
            tempAmount = tempAmount - tempAmortization;
            tempInterestRate = tempAmount * interestRate;
            tempAmortization = monthlyFee - tempInterestRate;
            monthlyPayment = new MonthlyPayment(i + 1, tempAmount, tempInterestRate, tempAmortization, monthlyFee, tempDate);
            result.add(monthlyPayment);
            tempDate = getNextDate(tempDate);
        }
        
        return result;
    }
 
    private void getNewMonthlyPaymentList(double newAmount) {
        this.monthlyFee = Formulas.monthlyFee(generateTerm(), newAmount, interestRate);
        double tempAmount = newAmount;
        double tempInterestRate;
        double tempAmortization = 0.0;
        MonthlyPayment mp;
        for (int i = 0; i < term; i++) {
            mp = monthlyPayments.get(i);
            if (mp.isPaid()) continue;
            tempAmount = tempAmount - tempAmortization;
            tempInterestRate = tempAmount * interestRate;
            tempAmortization = monthlyFee - tempInterestRate;
            mp.setBalance(tempAmount);
            mp.setInterest(tempInterestRate);
            mp.setFee(monthlyFee);
            mp.setAmortization(tempAmortization);
        }
    }
    
    private Date getNextDate(Date tempDate){
        int day = tempDate.getDay();
        int month = tempDate.getMonth();
        int year = tempDate.getYear();
        Date newDate;
        if(month == 12){
            newDate = new Date (day, 1, year + 1);
        } else {
            newDate = new Date (day, month + 1, year);
        }
        
        return newDate;
    }
    
    
    public void payTotal(){
        MonthlyPayment mp;
        for(int i = 0; i < monthlyPayments.size();i++){
            mp = monthlyPayments.get(i);
            mp.setPaid(true);
        }
        
        active = false;
    }
    
    public double getExtraordinaryPaymentTotal() {
        double total = 0.0;
        
        if (extraordinaryPayments != null) {
            for (int i = 0; i < extraordinaryPayments.size(); i++) {
                total += extraordinaryPayments.get(i);
            }
        }
        
        return total;
    }
    
    public double getPendingAmortizations() {
        double total = 0.0;
        MonthlyPayment mp;
        
        for (int i = 0; i < monthlyPayments.size(); i++) {
            mp = monthlyPayments.get(i);
            if(!mp.isPaid()) {
                total += mp.getAmortization();
            }
        }
        
        return total;
    }
    
    public boolean addExtraordinaryPayment(double extraordinaryPayment) {
        if (!active) return false;
        if (extraordinaryPayment > getPendingAmortizations()) return false;
        if(extraordinaryPayments == null) extraordinaryPayments = new ArrayList<>();
        
        extraordinaryPayments.add(extraordinaryPayment);
        double newAmount = getPendingAmortizations() - extraordinaryPayment;
        getNewMonthlyPaymentList(newAmount);
        return true;
    } 
    
    public boolean payMonthlyPayment() {
        MonthlyPayment mp = null;
        
        for (int i = 0; i < monthlyPayments.size(); i++) {
            mp = monthlyPayments.get(i);
            if(!mp.isPaid()){
                mp.setPaid(true);
                
                if(i == monthlyPayments.size() - 1) {
                    active = false;
                }
                
                return true;
            }
        }
        
        return false;
    } 
    
    public String getFormatDate(){
        return date.getDay()+"/"+date.getMonth()+"/"+date.getYear();
    }
}


