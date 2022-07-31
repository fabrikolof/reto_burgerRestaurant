package restaurante.chef.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.chef.values.Cook_ID;
import restaurante.chef.values.Name;
import restaurante.chef.values.PhoneNumber;

public class AddedCook extends DomainEvent {
    private final Cook_ID cook_id;
    private final Name name;
    private final PhoneNumber phoneNumber;

    public AddedCook(Cook_ID cook_id, Name name, PhoneNumber phoneNumber) {
        super("restaurante.chef.addedcook");
        this.cook_id = cook_id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Cook_ID getCook_id() {
        return cook_id;
    }

    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
