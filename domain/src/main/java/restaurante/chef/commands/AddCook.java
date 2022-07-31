package restaurante.chef.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.chef.values.Chef_ID;
import restaurante.chef.values.Name;
import restaurante.chef.values.PhoneNumber;

public class AddCook extends Command {
    private final Chef_ID chef_id;
    private final Name name;
    private final PhoneNumber phoneNumber;

    public AddCook(Chef_ID chef_id, Name name, PhoneNumber phoneNumber) {
        this.chef_id = chef_id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Chef_ID getChef_id() {
        return chef_id;
    }

    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
