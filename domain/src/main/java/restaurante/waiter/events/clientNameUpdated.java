package restaurante.waiter.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.waiter.values.Name;

public class clientNameUpdated extends DomainEvent {
    private final Name name;

    public clientNameUpdated(Name name) {
        super("restaurante.waiter.clientnameupdated");
        this.name = name;
    }

    public Name getName() {
        return name;
    }
}
