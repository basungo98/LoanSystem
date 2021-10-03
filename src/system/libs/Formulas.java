package system.libs;

public class Formulas {
    public static double monthlyFee(int term, double amount, double interestRate) {
        return (amount * interestRate)/(1-Math.pow(1+interestRate, -term));
    }
};
