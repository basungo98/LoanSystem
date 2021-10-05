package system.presentation.monthlyPayment_view;

import system.Application;
import system.logic.Client;
import system.logic.Loan;
import system.logic.Service;

public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        // invoke Model sets for initialization before linking to the view
        // problably get the data from Service
        view.setModel(model);
        view.setController(this);
    }
    
    public void getClient(String id){
        try {
            Client cliente = Service.instance().getClient(id);
            model.setClient(cliente);
            model.commit();
        } catch (Exception ex) {
            model.setClient(new Client());
            model.commit();
        }
    }
    
    public void payCurrentMonth(int loanIndex){
        Client client = model.getClient();
        Loan loan = client.getLoans().get(loanIndex);
        loan.payMonthlyPayment();
        model.setClient(client);
        model.commit();
        Service.instance().store();
    }
    
    public void payTotal(int loanIndex){
        Client client = model.getClient();
        Loan loan = client.getLoans().get(loanIndex);
        loan.payTotal();
        model.setClient(client);
        model.commit();
        Service.instance().store();
    }
    
    public void payExtraordinaryPayment(int loanIndex, double extraordinaryPayment){
        Client client = model.getClient();
        Loan loan = client.getLoans().get(loanIndex);
        loan.addExtraordinaryPayment(extraordinaryPayment);
        model.setClient(client);
        model.commit();
        Service.instance().store();
    }
    
    public boolean userExist(String id) {
        return Service.instance().userExist(id);
    }
    
    public void show(String clientId, int loanIndex) {
        this.view.baseConfiguration(clientId, loanIndex);
        this.view.setVisible(true);
    }
    
    public void hide() {
        this.view.setVisible(false);
    }
    
    public void exit() {
        Service.instance().store();
    }
    
    public void showLoanView(String clientId){
        this.hide();
        Application.LOAN_VIEW.show(clientId);
    }    
    
    
}