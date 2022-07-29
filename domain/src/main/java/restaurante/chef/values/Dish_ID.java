package restaurante.chef.values;

import co.com.sofka.domain.generic.Identity;

public class Dish_ID extends Identity {
    public Dish_ID(String id) {
        super(id);
    }
    public Dish_ID() {}
    public static Dish_ID of(String id) {
        return new Dish_ID(id);
    }
}
