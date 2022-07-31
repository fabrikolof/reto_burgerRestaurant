package restaurante.waiter.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.waiter.values.Note_ID;
import restaurante.waiter.values.Products;

public class noteProdutsUpdated extends DomainEvent {
    private Note_ID note_id;
    private Products products;

    public Note_ID getNote_id() {
        return note_id;
    }

    public Products getProducts() {
        return products;
    }

    public noteProdutsUpdated(Note_ID note_id, Products products) {
        super("restaurante.waiter.noteproductupdated");
        this.note_id = note_id;
        this.products = products;
    }
}
