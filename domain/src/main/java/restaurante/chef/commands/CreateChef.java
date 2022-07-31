package restaurante.chef.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.chef.values.Chef_ID;
import restaurante.chef.values.Name;
import restaurante.chef.values.PhoneNumber;


public class CreateChef extends Command {
    private final Chef_ID chef_ID;
    private final Name name;
    private final PhoneNumber phoneNumber;

    public CreateChef(Chef_ID chef_ID, Name name, PhoneNumber phoneNumber) {
        this.chef_ID = chef_ID;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Chef_ID getChef_ID() {
        return chef_ID;
    }
    public Name getName() {
        return name;
    }
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
