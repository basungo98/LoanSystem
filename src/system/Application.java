package system;

import java.util.List;
import system.libs.Formulas;
import system.logic.Date;
import system.logic.Loan;
import system.logic.MonthlyPayment;

public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        Loan loan1 = new Loan();
//        System.out.println(Formulas.monthlyFee(10000, 0.02, 6));
//        Loan loan = new Loan(6, 10000, 0.02, new Date());
//        List<MonthlyPayment> monthlyPayments = loan.getMonthlyPayments();
        
//        loan.payMonthlyPayment();
//        loan.addExtraordinaryPayment(10000);
//        loan.payMonthlyPayment();
//        loan.addExtraordinaryPayment(500);
//        loan.payMonthlyPayment();
//        loan.addExtraordinaryPayment(15000);
        
//        for (int i = 0; i < monthlyPayments.size(); i++) {
//            MonthlyPayment get = monthlyPayments.get(i);
//            System.out.println(get.getNumber() + " " + Math.round(get.getBalance()) + " " + Math.round(get.getInterest()) + " " + Math.round(get.getAmortization()) + " " + get.getPaid());
//        }
        
        
//        loan.addExtraordinaryPayment(1000);
//        System.out.println("-------------");
        
//       for (int i = 0; i < monthlyPayments.size(); i++) {
//            MonthlyPayment get = monthlyPayments.get(i);
//            System.out.println(get.getNumber() + " " + Math.round(get.getBalance()) + " " + Math.round(get.getInterest()) + " " + Math.round(get.getAmortization()) + " " + get.isPaid());
//        }
        
        system.presentation.splash_view.Model splashModel = new system.presentation.splash_view.Model() ;
        system.presentation.splash_view.View splashView = new system.presentation.splash_view.View();
        system.presentation.splash_view.Controller splashController = new system.presentation.splash_view.Controller(splashModel,splashView);
        SPLASH_VIEW = splashController;

        system.presentation.client_view.Model clientModel = new system.presentation.client_view.Model() ;
        system.presentation.client_view.View clientView = new system.presentation.client_view.View();
        system.presentation.client_view.Controller clientController = new system.presentation.client_view.Controller(clientModel,clientView);
        CLIENT_VIEW = clientController;

        system.presentation.loan_view.Model loanModel = new system.presentation.loan_view.Model() ;
        system.presentation.loan_view.View loanView = new system.presentation.loan_view.View();
        system.presentation.loan_view.Controller loanController = new system.presentation.loan_view.Controller(loanModel,loanView);
        LOAN_VIEW = loanController;
        
        system.presentation.report_view.Model reportModel = new system.presentation.report_view.Model() ;
        system.presentation.report_view.View reportView = new system.presentation.report_view.View();
        system.presentation.report_view.Controller reportController = new system.presentation.report_view.Controller(reportModel,reportView);
        REPORT_VIEW = reportController;
        
        system.presentation.monthlyPayment_view.Model monthlyPayment_view = new system.presentation.monthlyPayment_view.Model() ;
        system.presentation.monthlyPayment_view.View monthlyPaymentView = new system.presentation.monthlyPayment_view.View();
        system.presentation.monthlyPayment_view.Controller monthlyPaymentController = new system.presentation.monthlyPayment_view.Controller(monthlyPayment_view,monthlyPaymentView);
        MONTHLYPAYMENT_VIEW = monthlyPaymentController;

        SPLASH_VIEW.show();
    }

    public static system.presentation.splash_view.Controller SPLASH_VIEW;
    public static system.presentation.client_view.Controller CLIENT_VIEW;
    public static system.presentation.loan_view.Controller LOAN_VIEW;
    public static system.presentation.report_view.Controller REPORT_VIEW;
    public static system.presentation.monthlyPayment_view.Controller MONTHLYPAYMENT_VIEW;

}
