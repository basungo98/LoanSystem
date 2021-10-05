package system.presentation.monthlyPayment_view;

import system.Application;
import system.logic.Client;
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
}