package restaurante.waiter.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.waiter.values.Client_ID;
import restaurante.waiter.values.PhoneNumber;
import restaurante.waiter.values.Waiter_ID;

public class updateClientPhoneNumber extends Command {

    private final Client_ID client_ID;
    private final PhoneNumber phoneNumber;

    public Client_ID getClient_ID() {
        return client_ID;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public updateClientPhoneNumber(Client_ID client_ID, PhoneNumber phoneNumber) {
        this.client_ID = client_ID;
        this.phoneNumber = phoneNumber;
    }
}
