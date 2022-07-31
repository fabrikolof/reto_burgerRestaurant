package restaurante.chef.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.chef.values.Assistance_ID;
import restaurante.chef.values.Chef_ID;
import restaurante.chef.values.PhoneNumber;

public class updateAssitancePhoneNumber extends Command {
    private final Chef_ID chef_id;

    public Chef_ID getChef_id() {
        return chef_id;
    }

    public Assistance_ID getAssistance_ID() {
        return assistance_ID;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public updateAssitancePhoneNumber(Chef_ID chef_id, Assistance_ID assistance_ID, PhoneNumber phoneNumber) {
        this.chef_id = chef_id;
        this.assistance_ID = assistance_ID;
        this.phoneNumber = phoneNumber;
    }

    private final Assistance_ID assistance_ID;
    private final PhoneNumber phoneNumber;

}
