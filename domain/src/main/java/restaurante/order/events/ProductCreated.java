package restaurante.order.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.order.values.Details;
import restaurante.order.values.Price;
import restaurante.order.values.Product_ID;
import restaurante.order.values.Quantity;

public class ProductCreated extends DomainEvent {
    private Product_ID product_id;
    private Price price;
    private Quantity quantity;
    private Details details;

    public Price getPrice() {
        return price;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public Details getDetails() {
        return details;
    }

    public ProductCreated(Product_ID product_id, Price price, Quantity quantity, Details details) {
        super("restaurante.order.productcreated");
        this.product_id = product_id;
        this.price = price;
        this.quantity = quantity;
        this.details = details;
    }
}
