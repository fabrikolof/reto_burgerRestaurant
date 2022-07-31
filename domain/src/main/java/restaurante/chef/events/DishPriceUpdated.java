package restaurante.chef.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.chef.values.Dish_ID;
import restaurante.chef.values.Price;

public class DishPriceUpdated extends DomainEvent {
    private final Dish_ID dish_id;
    private final Price price;

    public DishPriceUpdated(Dish_ID dish_id, Price price) {
        super("restaurante.chef.dishpriceupdated");
        this.dish_id = dish_id;
        this.price = price;
    }

    public Dish_ID getDish_id() {
        return dish_id;
    }

    public Price getPrice() {
        return price;
    }
}
