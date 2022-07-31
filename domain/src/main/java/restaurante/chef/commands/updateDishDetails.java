package restaurante.chef.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.chef.values.Chef_ID;
import restaurante.chef.values.Details;
import restaurante.chef.values.Dish_ID;

public class updateDishDetails extends Command {
    private final Chef_ID chef_id;
    private final Dish_ID dish_id;
    private final Details details;

    public updateDishDetails(Chef_ID chef_id, Dish_ID dish_id, Details details) {
        this.chef_id = chef_id;
        this.dish_id = dish_id;
        this.details = details;
    }

    public Chef_ID getChef_id() {
        return chef_id;
    }

    public Dish_ID getDish_id() {
        return dish_id;
    }

    public Details getDetails() {
        return details;
    }
}
