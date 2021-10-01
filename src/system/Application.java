package system;

public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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

        SPLASH_VIEW.show();
    }

    public static system.presentation.splash_view.Controller SPLASH_VIEW;
    public static system.presentation.client_view.Controller CLIENT_VIEW;
    public static system.presentation.loan_view.Controller LOAN_VIEW;

}
