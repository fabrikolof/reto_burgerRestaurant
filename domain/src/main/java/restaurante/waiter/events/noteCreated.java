package restaurante.waiter.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.waiter.values.Clarifications;
import restaurante.waiter.values.Products;

public class noteCreated extends DomainEvent {
    private Clarifications clarifications;
    private Products products;

    public noteCreated(Clarifications clarifications, Products products) {
        super("restaurante.waiter.notecreated");
        this.clarifications = clarifications;
        this.products = products;
    }

    public Clarifications getClarifications() {
        return clarifications;
    }

    public Products getProducts() {
        return products;
    }
}
