package restaurante.waiter.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.waiter.values.Clarifications;
import restaurante.waiter.values.Note_ID;

public class updateNoteClarifications extends Command {
    //In Notes we found the clarifications of the clients
    private final Note_ID note_id;
    private final Clarifications clarifications;

    public updateNoteClarifications(Note_ID note_id, Clarifications clarifications) {
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
