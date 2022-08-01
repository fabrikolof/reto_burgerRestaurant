package restaurante.chef.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.chef.values.Assistance_ID;
import restaurante.chef.values.Chef_ID;

public class RemoveAssistance extends Command {
    private final Chef_ID chef_id;
    private final Assistance_ID assistance_id;

    public RemoveAssistance(Chef_ID chef_id, Assistance_ID assistance_id) {
        this.chef_id = chef_id;
        this.assistance_id = assistance_id;
    }

    public Chef_ID getChef_id() {
        return chef_id;
    }

    public Assistance_ID getAssistance_id() {
        return assistance_id;
    }
}
