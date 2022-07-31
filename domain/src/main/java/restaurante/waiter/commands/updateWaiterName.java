package restaurante.waiter.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.waiter.values.Name;
import restaurante.waiter.values.Waiter_ID;

public class updateWaiterName extends Command {
    private final Waiter_ID waiter_id;
    private final Name name;

    public updateWaiterName(Waiter_ID waiter_id, Name name) {
        this.waiter_id = waiter_id;
        this.name = name;
    }

    public Waiter_ID getWaiter_id() {
        return waiter_id;
    }

    public Name getName() {
        return name;
    }
}
