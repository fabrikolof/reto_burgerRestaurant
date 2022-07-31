package restaurante.chef.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.chef.values.Cook_ID;
import restaurante.chef.values.PhoneNumber;

public class CookPhoneNumberUpdated extends DomainEvent {
    private final Cook_ID cook_ID;
    private final PhoneNumber phoneNumber;

    public CookPhoneNumberUpdated(Cook_ID cook_ID, PhoneNumber phoneNumber) {
        super("cook_ID.chef.cookphonenumberupdated");
        this.cook_ID = cook_ID;
        this.phoneNumber = phoneNumber;
    }
    public Cook_ID getCook_ID() {
        return cook_ID;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
