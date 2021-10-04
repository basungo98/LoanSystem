package system.presentation.client_view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import system.Application;
import system.logic.Canton;
import system.logic.Client;
import system.logic.District;
import system.logic.Province;
import system.logic.Service;

public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        
        model.setClient(new Client());
        model.setClients(new ArrayList<>());
                
        view.setModel(model);
        view.setController(this);
        
        view.baseConfiguration();
    }
 
    public Province getProvince(String provinceName) {
        try {
            return Service.instance().getProvince(provinceName);
        } catch (Exception ex) {
           return new Province();
        }
    }
    
    public Canton getCanton(String provinceName, String cantonName) {
        try {
            List<Canton> cantons = getCantons(provinceName);
            return cantons.stream().filter(c->c.getName().equals(cantonName)).findFirst().orElse(null);
        } catch (Exception ex) {
           return new Canton();
        }
    }
    
    public District getDistrict(String provinceName, String cantonName, String districtName) {
        try {
            List<District> districts = getDistricts(provinceName, cantonName);
            return districts.stream().filter(c->c.getName().equals(districtName)).findFirst().orElse(null);
        } catch (Exception ex) {
           return new District();
        }
    }
    
    public List<Province> getProvinces() {
        try {
            return Service.instance().getProvinces();
        } catch (Exception ex) {
           return Arrays.asList(new Province());
        }
    }
   
    public List<Canton> getCantons(String provinceName) {
        try {
            Province province = Service.instance().getProvince(provinceName);
            return province.getCantons();
        } catch (Exception ex) {
           return Arrays.asList(new Canton());
        }
    }
    
    public List<District> getDistricts(String provinceName, String cantonName) {
        try {
            Province province = Service.instance().getProvince(provinceName);
            Canton canton = province.getCantons().stream().filter(c->c.getName().equals(cantonName)).findFirst().orElse(null);
            return canton.getDistricts();
        } catch (Exception ex) {
           return Arrays.asList(new District());
        }
    }
    
    public void addClient(Client cliente){
        try {
            Service.instance().addClient(cliente);
            model.setClient(new Client());
            model.commit();
            Service.instance().store();
        } catch (Exception ex) {
            
        }
        
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
    
    public void updateClient(Client newClient){
        try {
            Client client = Service.instance().getClient(newClient.getId());
            client.update(newClient);
            model.setClient(new Client());
            model.commit();
            Service.instance().store();
        } catch (Exception ex) {
            model.setClient(new Client());
            model.commit();
        }
    }
    
    public boolean userExist(String id) {
        return Service.instance().userExist(id);
    }
    
    public void show(){
        this.view.setVisible(true);
    }
    
    public void hide(){
        this.view.setVisible(false);
    }
    
    public void exit(){
        Service.instance().store();
    }
    
    public void showLoanView(String clientId){
        this.hide();
        Application.LOAN_VIEW.show(clientId);
    }  
}
