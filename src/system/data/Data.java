package system.data;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import system.logic.Client;
import system.logic.Province;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {
    private List<Client> clients;   
    private List<Province> provinces;

    public Data() {
        clients = new ArrayList<>();   
        provinces = new ArrayList<>(); 
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<Province> getProvinces() {
        return provinces;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }
}