package restaurante.waiter.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.waiter.values.Clarifications;
import restaurante.waiter.values.Note_ID;
import restaurante.waiter.values.Products;

public class noteCreated extends DomainEvent {
    private Note_ID note_id;
    private Clarifications clarifications;
    private Products products;

    public Note_ID getNote_id() {
        return note_id;
    }

    public Clarifications getClarifications() {
        return clarifications;
    }

    public Products getProducts() {
        return products;
    }

    public noteCreated(Note_ID note_id, Clarifications clarifications, Products products) {
        super("restaurante.waiter.notecreated");
        this.note_id = note_id;
        this.clarifications = clarifications;
        this.products = products;
    }
}
