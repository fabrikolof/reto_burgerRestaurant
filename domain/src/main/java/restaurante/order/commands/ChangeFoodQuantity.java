package restaurante.order.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.order.values.*;

public class ChangeFoodQuantity extends Command {
    private Order_ID order_id;
    private Food_ID food_id;
    protected Quantity quantity;

    public Order_ID getOrder_id() {
        return order_id;
    }

    public Food_ID getFood_id() {
        return food_id;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public ChangeFoodQuantity(Order_ID order_id, Food_ID food_id, Quantity quantity) {
        this.order_id = order_id;
        this.food_id = food_id;
        this.quantity = quantity;
    }
}
