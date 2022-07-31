package restaurante.order.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.order.values.Details;
import restaurante.order.values.Price;
import restaurante.order.values.Product_ID;

public class ProductDetailsUpdated extends DomainEvent {
    private Product_ID product_id;
    private Details details;

    public Details getDetails() {
        return details;
    }
    public ProductDetailsUpdated(Product_ID product_id, Details details) {
        super("restaurante.order.productdetailsupdated");
        this.product_id = product_id;
        this.details = details;
    }
}
