package restaurante.order.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.order.values.Details;
import restaurante.order.values.Order_ID;

public class updateProductDetails extends Command {
    private Order_ID order_id;
    protected Details details;

    public Order_ID getOrder_id() {
        return order_id;
    }

    public Details getDetails() {
        return details;
    }

    public updateProductDetails(Order_ID order_id, Details details) {
        this.order_id = order_id;
        this.details = details;
    }
}
