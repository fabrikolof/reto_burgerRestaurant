package restaurante.order.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.order.values.Details;
import restaurante.order.values.Order_ID;
import restaurante.order.values.Price;
import restaurante.order.values.Quantity;

public class addProduct extends Command {
    private Order_ID order_id;
    protected Price price;
    protected Quantity quantity;
    protected Details details;

    public Order_ID getOrder_id() {
        return order_id;
    }

    public Price getPrice() {
        return price;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public Details getDetails() {
        return details;
    }

    public addProduct(Order_ID order_id, Price price, Quantity quantity, Details details) {
        this.order_id = order_id;
        this.price = price;
        this.quantity = quantity;
        this.details = details;
    }
}
