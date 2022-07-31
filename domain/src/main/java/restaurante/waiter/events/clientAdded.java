package restaurante.waiter.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.waiter.values.Client_ID;
import restaurante.waiter.values.Name;
import restaurante.waiter.values.PhoneNumber;

public class clientAdded extends DomainEvent {
    private final Client_ID client_id;
    private final Name name;
    private final PhoneNumber phoneNumber;

    public Client_ID getClient_id() {
        return client_id;
    }

    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public clientAdded(Client_ID client_id, Name name, PhoneNumber phoneNumber) {
        super("restaurante.waiter.clientadded");
        this.client_id = client_id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }



}
