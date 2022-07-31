package restaurante.chef.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.chef.values.Chef_ID;
import restaurante.chef.values.PhoneNumber;

public class ChefPhoneNumberUpdated extends DomainEvent {
    private final Chef_ID chef_ID;
    private final PhoneNumber phoneNumber;
    public ChefPhoneNumberUpdated(Chef_ID chef_ID, PhoneNumber phoneNumber) {
        super("cook_ID.chef.chefphonenumberupdated");
        this.chef_ID = chef_ID;
        this.phoneNumber = phoneNumber;
    }
    public Chef_ID getChef_ID() {
        return chef_ID;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
