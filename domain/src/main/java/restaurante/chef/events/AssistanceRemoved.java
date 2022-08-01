package restaurante.chef.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.chef.values.Assistance_ID;

public class AssistanceRemoved extends DomainEvent {
    private final Assistance_ID assistance_id;
    private final Boolean wasDeleted;

    public AssistanceRemoved(Assistance_ID assistance_id) {
        super("restaurante.chef.assistanceremoved");
        this.assistance_id = assistance_id;
        this.wasDeleted = true;
    }

    public Assistance_ID getAssistance_id() {
        return assistance_id;
    }

    public Boolean getWasDeleted() {
        return wasDeleted;
    }
}
