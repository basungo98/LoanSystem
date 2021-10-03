package system.logic;

import java.util.ArrayList;
import java.util.List;
import system.libs.Formulas;

public class Loan {
    int term;
    double amount;
    double interestRate;
    double monthlyFee;
    boolean isActive;
    Date date;
    List<MonthlyPayment> monthlyPayments;
    List<Double> extraordinaryPayments;

    public Loan(int term, double amount, double interestRate, Date date) {
        this.term = term;
        this.amount = amount;
        this.interestRate = interestRate;
        this.monthlyFee = Formulas.monthlyFee(term, amount, interestRate);
        this.isActive = true;
        this.date = date;
        this.monthlyPayments = getMonthlyPaymentList();
        this.extraordinaryPayments = new ArrayList<>();
    }
    
    public Loan() {
        this.term = 0;
        this.amount = 0.0;
        this.interestRate = 0.0;
        this.monthlyFee = 0.0;
        this.isActive = false;
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

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
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
        double tempAmount = amount;
        double tempInterestRate;
        double tempAmortization = 0.0;
        for (int i = 0; i < term; i++) {
            tempAmount = tempAmount - tempAmortization;
            tempInterestRate = tempAmount * interestRate;
            tempAmortization = monthlyFee - tempInterestRate;
            monthlyPayment = new MonthlyPayment(i + 1, tempAmount, tempInterestRate, tempAmortization, monthlyFee, new Date());
            result.add(monthlyPayment);
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
    
    public double getExtraordinaryPaymentTotal() {
        double total = 0.0;
        
        for (int i = 0; i < extraordinaryPayments.size(); i++) {
            total += extraordinaryPayments.get(i);
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
        if (!isActive) return false;
        if (extraordinaryPayment > getPendingAmortizations()) return false;
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
                    isActive = false;
                }
                
                return true;
            }
        }
        
        return false;
    } 
}
