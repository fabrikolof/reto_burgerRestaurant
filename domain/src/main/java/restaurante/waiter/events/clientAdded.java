package restaurante.waiter.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.waiter.values.Name;
import restaurante.waiter.values.PhoneNumber;

import java.util.UUID;

public class clientAdded extends DomainEvent {
    private final Name name;
    private final PhoneNumber phoneNumber;

    public clientAdded(Name name, PhoneNumber phoneNumber) {
        super("restaurante.waiter.clientadded");
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
