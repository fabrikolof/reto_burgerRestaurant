package restaurante.order.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.order.values.Details;
import restaurante.order.values.Food_ID;
import restaurante.order.values.Order_ID;

public class updateFoodDetails extends Command {
    private Order_ID order_id;
    private Food_ID food_id;
    protected Details details;

    public Order_ID getOrder_id() {
        return order_id;
    }

    public Food_ID getFood_id() {
        return food_id;
    }

    public Details getDetails() {
        return details;
    }

    public updateFoodDetails(Order_ID order_id, Food_ID food_id, Details details) {
        this.order_id = order_id;
        this.food_id = food_id;
        this.details = details;
    }
}
