package restaurante.chef.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.chef.values.Assistance_ID;
import restaurante.chef.values.Chef_ID;
import restaurante.chef.values.Name;
import restaurante.chef.values.PhoneNumber;


public class CreateAssistance extends Command {
    private final Chef_ID chef_id;
    private final Name name;
    private final PhoneNumber phoneNumber;
    private final Assistance_ID assistance_id;

    public CreateAssistance(Chef_ID chef_id, Assistance_ID assistance_id, Name name, PhoneNumber phoneNumber) {
        this.chef_id = chef_id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.assistance_id = assistance_id;
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
