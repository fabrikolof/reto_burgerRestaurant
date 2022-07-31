package restaurante.waiter.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.waiter.values.Client_ID;
import restaurante.waiter.values.PhoneNumber;

public class clientPhoneNumberUpdated extends DomainEvent {
    private final Client_ID client_id;

    public Client_ID getClient_id() {
        return client_id;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public clientPhoneNumberUpdated(Client_ID client_id, PhoneNumber phoneNumber) {
        super("restaurante.waiter.clientphonenumberupdated");
        this.client_id = client_id;
        this.phoneNumber = phoneNumber;
    }

    private final PhoneNumber phoneNumber;

}
