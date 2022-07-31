package restaurante.chef.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.chef.values.Cook_ID;
import restaurante.chef.values.Details;
import restaurante.chef.values.Dish_ID;
import restaurante.chef.values.Price;

public class AddedDish extends DomainEvent {
    private final Dish_ID dish_id;
    private final Price price;
    private final Details details;

    public AddedDish(Dish_ID dish_id, Price price, Details details) {
        super("restaurante.chef.addeddish");
        this.dish_id = dish_id;
        this.price = price;
        this.details = details;
    }

    public Dish_ID getDish_id() {
        return dish_id;
    }

    public Price getPrice() {
        return price;
    }

    public Details getDetails() {
        return details;
    }
}
