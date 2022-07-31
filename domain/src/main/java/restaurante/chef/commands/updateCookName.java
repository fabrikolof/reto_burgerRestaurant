package restaurante.chef.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.chef.values.Chef_ID;
import restaurante.chef.values.Cook_ID;
import restaurante.chef.values.Name;

public class updateCookName extends Command {
    private final Chef_ID chef_id;
    private final Cook_ID cook_ID;
    private final Name name;

    public Chef_ID getChef_id() {
        return chef_id;
    }

    public Cook_ID getCook_ID() {
        return cook_ID;
    }

    public Name getName() {
        return name;
    }

    public updateCookName(Chef_ID chef_id, Cook_ID cook_ID, Name name) {
        this.chef_id = chef_id;
        this.cook_ID = cook_ID;
        this.name = name;
    }
}
