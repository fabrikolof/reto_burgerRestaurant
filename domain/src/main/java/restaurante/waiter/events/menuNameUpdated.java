package restaurante.waiter.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.waiter.values.Menu;

public class menuNameUpdated extends DomainEvent {
    private final Menu menu;

    public menuNameUpdated(Menu menu) {
        super("restaurante.waiter.menunameupdated");
        this.menu = menu;
    }
    public Menu getMenu() {
        return menu;
    }
}
