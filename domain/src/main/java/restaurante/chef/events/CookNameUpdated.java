package restaurante.chef.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.chef.values.Cook_ID;
import restaurante.chef.values.Name;

public class CookNameUpdated extends DomainEvent {
    private final Cook_ID cook_ID;
    private final Name name;

    public CookNameUpdated(Cook_ID cook_ID, Name name) {
        super("restaurante.chef.cooknameupdated");
        this.cook_ID = cook_ID;
        this.name = name;
    }
    public Cook_ID getCook_ID() {
        return cook_ID;
    }

    public Name getName() {
        return name;
    }


}
