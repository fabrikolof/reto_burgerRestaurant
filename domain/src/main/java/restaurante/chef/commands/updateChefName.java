package restaurante.chef.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.chef.values.Chef_ID;
import restaurante.chef.values.Name;
import restaurante.chef.values.PhoneNumber;

public class updateChefName extends Command {
    private final Chef_ID chef_id;
    protected Name name;

    public updateChefName(Chef_ID chef_id, Name name) {
        this.chef_id = chef_id;
        this.name = name;
    }

    public Chef_ID getChef_id() {
        return chef_id;
    }

    public Name getName() {
        return name;
    }
}
