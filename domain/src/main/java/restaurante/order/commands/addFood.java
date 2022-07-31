package restaurante.order.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.order.values.*;

public class addFood extends Command {
    private Order_ID order_id;
    private Food_ID food_id;
    protected Price price;
    protected Quantity quantity;
    protected Details details;

    public addFood(Order_ID order_id, Food_ID food_id, Price price, Quantity quantity, Details details) {
        this.order_id = order_id;
        this.food_id = food_id;
        this.price = price;
        this.quantity = quantity;
        this.details = details;
    }

    public Order_ID getOrder_id() {
        return order_id;
    }

    public Food_ID getFood_id() {
        return food_id;
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
}
