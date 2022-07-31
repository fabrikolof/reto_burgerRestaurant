package restaurante.waiter.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.waiter.values.Clarifications;
import restaurante.waiter.values.Note_ID;
import restaurante.waiter.values.Products;
import restaurante.waiter.values.Waiter_ID;

public class CreateNote extends Command {
    private final Waiter_ID waiter_id;
    private final Note_ID note_id;
    private Clarifications clarifications;
    private Products products;

    public Clarifications getClarifications() {
        return clarifications;
    }

    public Products getProducts() {
        return products;
    }

    public Waiter_ID getWaiter_id() {
        return waiter_id;
    }

    public Note_ID getNote_id() {
        return note_id;
    }

    public CreateNote(Waiter_ID waiter_id, Note_ID note_id, Note_ID note_id1, Clarifications clarifications, Products products) {
        this.waiter_id = waiter_id;
        this.note_id = note_id;
        this.clarifications = clarifications;
        this.products = products;
    }
}
