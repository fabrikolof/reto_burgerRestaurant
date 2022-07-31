package restaurante.order.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.order.values.Food_ID;
import restaurante.order.values.Price;
import restaurante.order.values.Quantity;

public class ChangeFoodQuantityUpdated extends DomainEvent {
    private Food_ID food_id;
    private Quantity quantity;

    public ChangeFoodQuantityUpdated(Food_ID food_id, Quantity quantity) {
        super("restaurante.order.changefoodquantityupdated");
        this.food_id = food_id;
        this.quantity = quantity;
    }

    public Food_ID getFood_id() {
        return food_id;
    }

    public Quantity getQuantity() {
        return quantity;
    }
}
