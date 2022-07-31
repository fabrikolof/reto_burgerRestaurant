package restaurante.waiter.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.waiter.values.Name;
import restaurante.waiter.values.Waiter_ID;

public class waiterNameUpdated extends DomainEvent {
    private final Waiter_ID waiter_id;

    public Waiter_ID getWaiter_id() {
        return waiter_id;
    }

    public Name getName() {
        return name;
    }

    public waiterNameUpdated(Waiter_ID waiter_id, Name name) {
        super("restaurante.waiter.waiternameupdated");
        this.waiter_id = waiter_id;
        this.name = name;
    }

    private final Name name;

}
