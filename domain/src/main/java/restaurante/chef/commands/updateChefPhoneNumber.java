package restaurante.chef.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.chef.values.Chef_ID;
import restaurante.chef.values.PhoneNumber;

public class updateChefPhoneNumber extends Command {
    private final Chef_ID chef_ID;
    private final PhoneNumber phoneNumber;
    public updateChefPhoneNumber(Chef_ID chef_ID, PhoneNumber phoneNumber) {
        this.chef_ID = chef_ID;
        this.phoneNumber = phoneNumber;
    }

    public Chef_ID getChef_ID() {
        return chef_ID;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
