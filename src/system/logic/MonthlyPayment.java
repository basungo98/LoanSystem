package system.logic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class MonthlyPayment {
    int number;
    double balance;
    double interest;
    double amortization;
    double fee;
    boolean paid;
    Date date;
    
    public MonthlyPayment(int number, double balance, double interest, double amortization, double fee, Date date) {
        this.number = number;
        this.balance = balance;
        this.interest = interest;
        this.amortization = amortization;
        this.fee = fee;
        this.paid = false;
        this.date = date;
    }

   
    
    public MonthlyPayment() {
        this.number = 0;
        this.balance = 0.0;
        this.interest = 0.0;
        this.amortization = 0.0;
        this.fee = 0.0;
        this.paid = false;
        this.date = null;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getAmortization() {
        return amortization;
    }

    public void setAmortization(double amortization) {
        this.amortization = amortization;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
      public String getFormatDate(){
        return date.getDay()+"/"+date.getMonth()+"/"+date.getYear();
    }
}
