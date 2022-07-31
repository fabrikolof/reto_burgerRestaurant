package restaurante.chef.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.chef.values.Chef_ID;
import restaurante.chef.values.Name;
import restaurante.chef.values.PhoneNumber;

public class ChefNameUpdated extends DomainEvent {
    private Chef_ID chef_id;
    private Name name;
    public ChefNameUpdated(Chef_ID chef_id, Name name) {
        super("restaurante.chef.chefnameupdated");
        this.chef_id = chef_id;
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public Chef_ID getChef_id() {
        return chef_id;
    }
}

