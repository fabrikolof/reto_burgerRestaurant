package restaurante.chef.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.chef.values.Details;
import restaurante.chef.values.Dish_ID;

public class DishDetailsUpdated extends DomainEvent {
    private final Dish_ID dish_id;
    private final Details details;

    public DishDetailsUpdated(Dish_ID dish_id, Details details) {
        super("restaurante.chef.dishdetailsupdated");
        this.dish_id = dish_id;
        this.details = details;
    }

    public Dish_ID getDish_id() {
        return dish_id;
    }

    public Details getDetails() {
        return details;
    }
}
