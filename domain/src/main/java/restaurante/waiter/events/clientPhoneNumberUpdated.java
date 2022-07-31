package restaurante.waiter.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.waiter.values.PhoneNumber;

public class clientPhoneNumberUpdated extends DomainEvent {
    private final PhoneNumber phoneNumber;

    public clientPhoneNumberUpdated(String type, PhoneNumber phoneNumber) {
        super("restaurante.waiter.clientphonenumberupdated");
        this.phoneNumber = phoneNumber;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
