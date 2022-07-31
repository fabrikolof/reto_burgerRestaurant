package restaurante.waiter.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.waiter.values.PhoneNumber;

public class waiterPhoneNumberUpdated extends DomainEvent {
    private final PhoneNumber phoneNumber;

    public waiterPhoneNumberUpdated(String type, PhoneNumber phoneNumber) {
        super("restaurante.waiter.waiterphonenumberupdated");
        this.phoneNumber = phoneNumber;
    }
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
