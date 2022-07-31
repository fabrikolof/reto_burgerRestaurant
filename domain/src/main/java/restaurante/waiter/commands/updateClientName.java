package restaurante.waiter.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.waiter.values.Client_ID;
import restaurante.waiter.values.Name;
import restaurante.waiter.values.Waiter_ID;

public class updateClientName extends Command {
    private final Waiter_ID waiter_ID;
    private final Client_ID client_ID;
    private final Name name;

    public updateClientName(Waiter_ID waiter_ID, Client_ID client_ID, Name name) {
        this.waiter_ID = waiter_ID;
        this.client_ID = client_ID;
        this.name = name;
    }

    public Waiter_ID getWaiter_ID() {
        return waiter_ID;
    }

    public Client_ID getClient_ID() {
        return client_ID;
    }

    public Name getName() {
        return name;
    }
}
