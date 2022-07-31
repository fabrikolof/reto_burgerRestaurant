package restaurante.waiter.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.waiter.values.Client_ID;
import restaurante.waiter.values.PhoneNumber;
import restaurante.waiter.values.Waiter_ID;

public class updateClientPhoneNumber extends Command {
    private final Waiter_ID waiter_id;
    private final Client_ID client_ID;
    private final PhoneNumber phoneNumber;

    public Waiter_ID getWaiter_id() {
        return waiter_id;
    }

    public Client_ID getClient_ID() {
        return client_ID;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public updateClientPhoneNumber(Waiter_ID waiter_id, Client_ID client_ID, PhoneNumber phoneNumber) {
        this.waiter_id = waiter_id;
        this.client_ID = client_ID;
        this.phoneNumber = phoneNumber;
    }
}
