package restaurante.order.events;

import co.com.sofka.domain.generic.DomainEvent;

public class NotifyOrderCreated extends DomainEvent {
    private final String message;

    public NotifyOrderCreated(String message) {
        super("restaurante.order.notifyordercreated");
        {
            this.message = message;
        }
    }

    public String getMessage() {
        return message;
    }
}
