package system.logic;

import java.util.List;
import system.data.Data;
import system.data.XmlPersister;

public class Service {
    
    // Singleton implementation
    private static Service theInstance;
    public static Service instance(){
        if (theInstance==null){ 
            theInstance=new Service();
        }
        return theInstance;
    }
    
    // Service data
    private Data data;
    
    public Province getProvince(String provinceName) throws Exception {
        Province province = data.getProvinces().stream().filter(pro->pro.getName().equals(provinceName)).findFirst().orElse(null);
        if (province != null ) {
            return province;
        }
        else {
            throw new Exception("No fue posible cargar los datos de provincias.");
        }   
    }
    
    public List<Province> getProvinces() throws Exception {
        List<Province> provinces = data.getProvinces();
        if (provinces != null ) {
            return provinces;
        }
        else {
            throw new Exception("No fue posible cargar los datos de provincias.");
        }   
    }
    
     public void addClient(Client cliente) throws Exception{
        Client old = data.getClients().stream().filter(c->c.getId().equals(cliente.getId())).findFirst().orElse(null);
        if (old == null) {
            data.getClients().add(cliente);
            XmlPersister.instance().store(data);
        }
        else {
            throw new Exception("Cliente ya existe");
        }    
    }
     
    public Client getClient(String id) throws Exception{
        Client result = data.getClients().stream().filter(c->c.getId().equals(id)).findFirst().orElse(null);
        if (result != null) {
            return result;
        }
        else {
            throw new Exception("Cliente no existe");
        }   
    }
    
     public boolean userExist(String id) {
        Client result = data.getClients().stream().filter(c->c.getId().equals(id)).findFirst().orElse(null);
        if (result == null) {
            return false;
        }
        
        return true;
    }
     
    public void store(){
        try {
            XmlPersister.instance().store(data);
        } catch (Exception ex) {
        }
    }
    
    public Service() {
        try{
            data=XmlPersister.instance().load();
        }
        catch(Exception e){
            data =  new Data();
        }

    }
    
}
