package restaurante.waiter.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.waiter.values.Note_ID;
import restaurante.waiter.values.Products;
import restaurante.waiter.values.Waiter_ID;

public class updateNoteProducts extends Command {
    //product are in the note
    private final Waiter_ID waiter_id;
    private Note_ID note_id;
    private Products products;

    public Waiter_ID getWaiter_id() {
        return waiter_id;
    }

    public updateNoteProducts(Waiter_ID waiter_id, Note_ID note_id, Products products) {
        this.waiter_id = waiter_id;
        this.note_id = note_id;
        this.products = products;
    }

    public Note_ID getNote_id() {
        return note_id;
    }

    public Products getProducts() {
        return products;
    }
}
