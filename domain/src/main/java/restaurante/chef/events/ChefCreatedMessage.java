package restaurante.chef.events;

import co.com.sofka.domain.generic.DomainEvent;

    //1 triggered per event
public class ChefCreatedMessage extends DomainEvent {
    private final String message;

    public ChefCreatedMessage(String message) {
        super("restaurante.chef.dishaddedmessage");
        {
            this.message = message;
        }
    }

    public String getMessage() {
        return message;
    }
}
