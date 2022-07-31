package restaurante.order.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.order.values.Order_ID;
import restaurante.order.values.Quantity;

public class ChangeProductQuantity extends Command {
    private Order_ID order_id;
    protected Quantity quantity;

    public Order_ID getOrder_id() {
        return order_id;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public ChangeProductQuantity(Order_ID order_id, Quantity quantity) {
        this.order_id = order_id;
        this.quantity = quantity;
    }
}
