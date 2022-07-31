package restaurante.chef.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.chef.values.Assistance_ID;
import restaurante.chef.values.Name;

public class AssitanceNameUpdated extends DomainEvent {
    private final Assistance_ID assistance_ID;
    private final Name name;

    public AssitanceNameUpdated(Assistance_ID assistance_ID, Name name) {
        super("restaurante.chef.assitancenameupdated");
        this.assistance_ID = assistance_ID;
        this.name = name;
    }
    public Assistance_ID getAssistance_ID() {
        return assistance_ID;
    }

    public Name getName() {
        return name;
    }

}
