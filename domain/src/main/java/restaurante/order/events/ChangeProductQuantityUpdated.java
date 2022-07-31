package restaurante.order.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.order.values.Product_ID;
import restaurante.order.values.Quantity;

public class ChangeProductQuantityUpdated extends DomainEvent {
    private Product_ID product_id;
    private Quantity quantity;

    public Product_ID getProduct_id() {
        return product_id;
    }


    public Quantity getQuantity() {
        return quantity;
    }

    public ChangeProductQuantityUpdated(Product_ID product_id, Quantity quantity) {
        super("restaurante.order.changeproductquantityupdated");
        this.product_id = product_id;
        this.quantity = quantity;
    }
}
