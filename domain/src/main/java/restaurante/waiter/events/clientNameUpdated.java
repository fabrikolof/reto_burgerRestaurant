package restaurante.waiter.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.waiter.values.Client_ID;
import restaurante.waiter.values.Name;

public class clientNameUpdated extends DomainEvent {
    private final Client_ID client_id;

    public Client_ID getClient_id() {
        return client_id;
    }

    public Name getName() {
        return name;
    }

    public clientNameUpdated(Client_ID client_id, Name name) {
        super("restaurante.waiter.clientnameupdate");
        this.client_id = client_id;
        this.name = name;
    }

    private final Name name;

}
