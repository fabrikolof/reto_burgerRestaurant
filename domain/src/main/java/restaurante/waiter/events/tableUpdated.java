package restaurante.waiter.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.waiter.values.Capacity;
import restaurante.waiter.values.Menu;

public class tableUpdated extends DomainEvent {
    private final Menu menu;
    private final Capacity capacity;

    public tableUpdated(Menu menu, Capacity capacity) {
        super("restaurante.waiter.tableupdated");
        this.menu = menu;
        this.capacity = capacity;
    }

    public Menu getMenu() {
        return menu;
    }

    public Capacity getCapacity() {
        return capacity;
    }
}
