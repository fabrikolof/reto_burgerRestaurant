package restaurante.chef.entities;

import co.com.sofka.domain.generic.Entity;
import restaurante.chef.values.Assistance_ID;
import restaurante.chef.values.Name;
import restaurante.chef.values.PhoneNumber;

import java.util.Objects;

public class Assitance extends Entity<Assistance_ID> {
    protected Name name;
    protected PhoneNumber phoneNumber;
    public Assitance(Assistance_ID assistance_id, Name name, PhoneNumber phoneNumber) {
        super(assistance_id);
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public Name getName() {
        return name;
    }
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
    public void updateName(Name name){
        this.name = Objects.requireNonNull(name);
    }
    public void updatePhoneNumber(PhoneNumber phoneNumber){
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
    }
    public void prepareProducts(){
        //Set of product to get ready
        //Send events to another sector, turn ON something
    }

}
