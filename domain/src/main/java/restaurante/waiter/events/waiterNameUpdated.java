package restaurante.waiter.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.waiter.values.Name;

public class waiterNameUpdated extends DomainEvent {
    private final Name name;

    public waiterNameUpdated(Name name) {
        super("restaurante.waiter.waiternameupdated");
        this.name = name;
    }

    public Name getName() {
        return name;
    }
}
