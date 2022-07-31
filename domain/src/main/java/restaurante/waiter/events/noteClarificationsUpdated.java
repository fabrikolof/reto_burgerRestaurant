package restaurante.waiter.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.waiter.values.Clarifications;
import restaurante.waiter.values.Note_ID;

public class noteClarificationsUpdated extends DomainEvent {
    private final Note_ID note_id;
    private final Clarifications clarifications;

    public Note_ID getNote_id() {
        return note_id;
    }

    public Clarifications getClarifications() {
        return clarifications;
    }

    public noteClarificationsUpdated(Note_ID note_id, Clarifications clarifications) {
        super("restaurante.waiter.noteclarificationsupdated");
        this.note_id = note_id;
        this.clarifications = clarifications;
    }
}
