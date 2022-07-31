package restaurante.waiter.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.waiter.values.Client_ID;
import restaurante.waiter.values.Name;
import restaurante.waiter.values.PhoneNumber;
import restaurante.waiter.values.Waiter_ID;

public class AddClient extends Command {
    private final Waiter_ID waiter_id;
    private final Client_ID client_id;
    private final Name name;
    private final PhoneNumber phoneNumber;

    public AddClient(Waiter_ID waiter_id, Client_ID trainerID, Name name, PhoneNumber phoneNumber) {
        this.waiter_id = waiter_id;
        this.client_id = trainerID;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Client_ID getClient_id() {
        return client_id;
    }

    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Waiter_ID getWaiter_id() {
        return waiter_id;
    }
}
