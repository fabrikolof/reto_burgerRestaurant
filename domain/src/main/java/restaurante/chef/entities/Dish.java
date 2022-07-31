package restaurante.chef.entities;

import co.com.sofka.domain.generic.Entity;
import restaurante.chef.values.*;

import java.util.Objects;

public class Dish extends Entity<Dish_ID> {
    protected Price price;
    protected Details details;
    public Dish(Dish_ID dish_ID, Price price, Details details) {
        super(dish_ID);
        this.price = price;
        this.details = details;
    }
    public Price getPrice() {
        return price;
    }
    public Details getDetails() {
        return details;
    }
    public void updatePrice(Price price) {
        this.price = price;
    }
    public void updateDetails(Details details) {
        this.details = Objects.requireNonNull(details);
    }

}
