package restaurante.order.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.order.values.Details;
import restaurante.order.values.Food_ID;


public class FoodDetailsUpdated extends DomainEvent {
    private Food_ID food_id;
    private Details details;


    public FoodDetailsUpdated(Food_ID food_id, Details details) {
        super("restaurante.order.fooddetailsupdated");
        this.food_id = food_id;
        this.details = details;
    }
    public Details getDetails() {
        return details;
    }
    public Food_ID getFood_id() {
        return food_id;
    }
}
