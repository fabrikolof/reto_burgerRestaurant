package restaurante.chef.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.chef.values.Chef_ID;
import restaurante.chef.values.Cook_ID;
import restaurante.chef.values.PhoneNumber;

public class updateCookPhoneNumber extends Command {
    private final Chef_ID chef_id;

    public Chef_ID getChef_id() {
        return chef_id;
    }

    public Cook_ID getCook_ID() {
        return cook_ID;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public updateCookPhoneNumber(Chef_ID chef_id, Cook_ID cook_ID, PhoneNumber phoneNumber) {
        this.chef_id = chef_id;
        this.cook_ID = cook_ID;
        this.phoneNumber = phoneNumber;
    }

    private final Cook_ID cook_ID;
    private final PhoneNumber phoneNumber;

}
