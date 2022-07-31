package restaurante.chef.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.chef.values.Assistance_ID;
import restaurante.chef.values.Chef_ID;
import restaurante.chef.values.Name;

public class updateAssitanceName extends Command {
    private final Chef_ID chef_id;
    private final Assistance_ID assistance_ID;
    private final Name name;
    public updateAssitanceName(Chef_ID chef_id, Assistance_ID assistance_ID, Name name) {
        this.chef_id = chef_id;
        this.assistance_ID = assistance_ID;
        this.name = name;
    }
    public Chef_ID getChef_id() {
        return chef_id;
    }
    public Assistance_ID getAssistance_ID() {
        return assistance_ID;
    }
    public Name getName() {
        return name;
    }

}
