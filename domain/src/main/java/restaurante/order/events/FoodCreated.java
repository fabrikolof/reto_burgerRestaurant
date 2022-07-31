package restaurante.order.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.order.values.Details;
import restaurante.order.values.Food_ID;
import restaurante.order.values.Price;
import restaurante.order.values.Quantity;

public class FoodCreated extends DomainEvent {
    private Food_ID food_id;
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

    public FoodCreated(Food_ID food_id, Price price, Quantity quantity, Details details) {
        super("restaurante.order.foodcreated");
        this.food_id = food_id;
        this.price = price;
        this.quantity = quantity;
        this.details = details;
    }
}
