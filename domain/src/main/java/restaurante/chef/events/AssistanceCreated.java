package restaurante.chef.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.chef.values.Assistance_ID;
import restaurante.chef.values.Name;
import restaurante.chef.values.PhoneNumber;

public class AssistanceCreated extends DomainEvent {
    private final Assistance_ID assistance_id;
    private final Name name;
    private final PhoneNumber phoneNumber;

    public AssistanceCreated(Assistance_ID assistance_id, Name name, PhoneNumber phoneNumber) {
        super("restaurante.chef.assistancecreated");
        this.assistance_id = assistance_id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Assistance_ID getAssistance_id() {
        return assistance_id;
    }

    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
