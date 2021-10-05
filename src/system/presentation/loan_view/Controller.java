package system.presentation.loan_view;

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
            Client client = Service.instance().getClient(id);
            model.setClient(client);
            model.commit();
        } catch (Exception ex) {
            model.setClient(new Client());
            model.commit();
        }
    }
    
    public boolean userExist(String id) {
        return Service.instance().userExist(id);
    }
    
    public void show(String clientId) {
        this.view.baseConfiguration(clientId);
        this.view.setVisible(true);
    }
    
    public void hide() {
        this.view.setVisible(false);
    }
    
    public void exit() {
        Service.instance().store();
    }
    
    public void showClientView(){
        this.hide();
        Application.CLIENT_VIEW.show();
    }    
    
     public void showMonthlyPaymentView(String clientId, int loanIndex ){
        this.hide();
        Application.MONTHLYPAYMENT_VIEW.show(clientId, loanIndex);
    }
     
    public void setLoan(Loan loan){
        Client client = model.getClient();
        if(client != null){
            client.addLoan(loan);
            model.setClient(client);
            model.commit();
            Service.instance().store();
        }
    }
}