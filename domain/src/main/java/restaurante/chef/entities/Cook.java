package restaurante.chef.entities;

import co.com.sofka.domain.generic.Entity;
import restaurante.chef.values.Cook_ID;
import restaurante.chef.values.Name;
import restaurante.chef.values.PhoneNumber;

import java.util.Objects;

public class Cook extends Entity<Cook_ID> {
    protected Name name;
    protected PhoneNumber phoneNumber;
    public Cook(Cook_ID cook_ID, Name name, PhoneNumber phoneNumber) {
        super(cook_ID);
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
        this.phoneNumber = phoneNumber;
    }
    public void cookDishes(){
        //Set of dishes to cook
        //Send events to another sector, turn ON something
    }
}
