package restaurante.waiter.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.waiter.values.Clarifications;

public class noteClarificationsUpdated extends DomainEvent {
    private final Clarifications clarifications;

    public noteClarificationsUpdated(String type, Clarifications clarifications) {
        super("restaurante.waiter.noteclarificationsupdated");
        this.clarifications = clarifications;
    }

    public Clarifications getClarifications() {
        return clarifications;
    }
}
