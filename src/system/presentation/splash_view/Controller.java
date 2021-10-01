package system.presentation.splash_view;

import system.Application;
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
    
    public void show(){
        this.view.setVisible(true);
        view.progressBarSetUp();
    }
    
    public void hide(){
        this.view.setVisible(false);
    }
    
    public void exit(){
        Service.instance().store();
    }
    
    // Controller methods that respond to View events
    // probably invoke methods from Service,
    // and set data to Model, which in turn causes the View to update 
    
    public void showClientView(){
        this.hide();
        Application.CLIENT_VIEW.show();
    }  
}
