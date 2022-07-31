package restaurante.waiter.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.waiter.values.PhoneNumber;
import restaurante.waiter.values.Waiter_ID;

public class waiterPhoneNumberUpdated extends DomainEvent {
    private final Waiter_ID waiter_id;

    public Waiter_ID getWaiter_id() {
        return waiter_id;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public waiterPhoneNumberUpdated(Waiter_ID waiter_id, PhoneNumber phoneNumber) {
        super("restaurante.waiter.waiterphonenumberupdated");
        this.waiter_id = waiter_id;
        this.phoneNumber = phoneNumber;
    }

    private final PhoneNumber phoneNumber;

}
