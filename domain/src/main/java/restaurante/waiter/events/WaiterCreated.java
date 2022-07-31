package restaurante.waiter.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.waiter.values.Name;
import restaurante.waiter.values.PhoneNumber;
import restaurante.waiter.values.Waiter_ID;

public class WaiterCreated extends DomainEvent {
    private final Waiter_ID waiter_id;
    private final Name name;
    private final PhoneNumber phoneNumber;

    public WaiterCreated(Waiter_ID waiter_id, Name name, PhoneNumber phoneNumber) {
        super("restaurante.waiter.waitercreated");
        this.waiter_id = waiter_id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Waiter_ID getWaiter_id() {
        return waiter_id;
    }

    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
