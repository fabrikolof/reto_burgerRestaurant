package restaurante.waiter.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.waiter.values.Clarifications;
import restaurante.waiter.values.Note_ID;
import restaurante.waiter.values.Waiter_ID;

public class updateNoteClarifications extends Command {
    //In Notes we found the clarifications of the clients
    private final Waiter_ID waiter_id;
    private final Note_ID note_id;
    private final Clarifications clarifications;

    public Waiter_ID getWaiter_id() {
        return waiter_id;
    }

    public Clarifications getClarificatio() {
        return clarifications;
    }

    public updateNoteClarifications(Waiter_ID waiter_id, Note_ID note_id, Clarifications clarifications) {
        this.waiter_id = waiter_id;
        this.note_id = note_id;
        this.clarifications = clarifications;
    }

    public Note_ID getNote_id() {
        return note_id;
    }

    public Clarifications getClarifications() {
        return clarifications;
    }
}
