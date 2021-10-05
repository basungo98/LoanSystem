package system.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;

@XmlAccessorType(XmlAccessType.FIELD)
public class Client {
 @XmlID   
 String id;
 String name;
 @XmlIDREF
 Province province;
 Canton canton;
 District district;
 List<Loan> loans;

    public Client(String id, String name, Province province, Canton canton, District district) {
        this.id = id;
        this.name = name;
        this.province = province;
        this.canton = canton;
        this.district = district;
        this.loans = new ArrayList<>();
    }

    public Client() {
        this.id = "";
        this.name = "";
        this.province = new Province();
        this.canton = new Canton();
        this.district = new District();
        this.loans = null;
    }
    
    public void update(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.province = client.getProvince();
        this.canton = client.getCanton();
        this.district = client.getDistrict();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Canton getCanton() {
        return canton;
    }

    public void setCanton(Canton canton) {
        this.canton = canton;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
    
    public void addLoan(Loan loan){
        if (this.loans == null){
            this.loans = new ArrayList<>();
        }
        this.loans.add(loan);
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
}
