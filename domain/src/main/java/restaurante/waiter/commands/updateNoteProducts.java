package restaurante.waiter.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.waiter.values.Note_ID;
import restaurante.waiter.values.Products;

public class updateNoteProducts extends Command {
    //product are in the note
    private Note_ID note_id;
    private Products products;

    public updateNoteProducts(Note_ID note_id, Products products) {
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
