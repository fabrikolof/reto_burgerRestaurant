package restaurante.waiter.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.waiter.values.Capacity;
import restaurante.waiter.values.Menu;
import restaurante.waiter.values.Table_ID;

public class tableUpdated extends DomainEvent {
    private final Table_ID table_id;

    public Table_ID getTable_id() {
        return table_id;
    }

    public Menu getMenu() {
        return menu;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public tableUpdated(Table_ID table_id, Menu menu, Capacity capacity) {
        super("restaurante.waiter.tableupdated");
        this.table_id = table_id;
        this.menu = menu;
        this.capacity = capacity;
    }

    private final Menu menu;
    private final Capacity capacity;

}
