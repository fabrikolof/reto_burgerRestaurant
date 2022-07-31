package restaurante.chef.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.chef.values.Assistance_ID;
import restaurante.chef.values.PhoneNumber;

public class AssistancePhoneNumberUpdated extends DomainEvent {
    private final Assistance_ID assistance_ID;
    private final PhoneNumber phoneNumber;

    public AssistancePhoneNumberUpdated(Assistance_ID assistance_ID, PhoneNumber phoneNumber) {
        super("restaurant.chef.assistancephonenumberupdated");
        this.assistance_ID = assistance_ID;
        this.phoneNumber = phoneNumber;
    }
    public Assistance_ID getAssistance_ID() {
        return assistance_ID;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
