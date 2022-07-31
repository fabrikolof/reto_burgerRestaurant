package restaurante.waiter.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.waiter.values.Products;

public class noteProdutsUpdated extends DomainEvent {
    private Products products;

    public noteProdutsUpdated(String type, Products products) {
        super("restaurante.waiter.noteproductupdated");
        this.products = products;
    }
    public Products getProducts() {
        return products;
    }
}
