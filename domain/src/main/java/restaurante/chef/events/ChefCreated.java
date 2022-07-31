package restaurante.chef.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.chef.values.Chef_ID;
import restaurante.chef.values.Name;
import restaurante.chef.values.PhoneNumber;

public class ChefCreated extends DomainEvent {
    private final Chef_ID chef_id;
    private final Name name;
    private final PhoneNumber phoneNumber;

    public ChefCreated(Chef_ID chef_id, Name name, PhoneNumber phoneNumber) {
        super("restaurante.chef.chefcreated");
        this.chef_id = chef_id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Chef_ID getChef_id() {
        return chef_id;
    }
    public Name getName() {
        return this.name;
    }
    public PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }
}
