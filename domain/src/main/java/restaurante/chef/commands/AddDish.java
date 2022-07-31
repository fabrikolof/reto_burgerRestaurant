package restaurante.chef.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.chef.values.Chef_ID;
import restaurante.chef.values.Details;
import restaurante.chef.values.Price;

public class AddDish extends Command {
    private final Chef_ID chef_id;
    private final Price price;
    private final Details details;

    public AddDish(Chef_ID chef_id, Price price, Details details) {
        this.chef_id = chef_id;
        this.price = price;
        this.details = details;
    }

    public Chef_ID getChef_id() {
        return chef_id;
    }

    public Price getPrice() {
        return price;
    }

    public Details getDetails() {
        return details;
    }
}
