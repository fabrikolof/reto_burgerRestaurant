package restaurante.waiter.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.waiter.values.Capacity;
import restaurante.waiter.values.Menu;
import restaurante.waiter.values.Table_ID;

public class TableCreated extends DomainEvent {
    private Table_ID table_id;
    private Menu menu;
    private Capacity capacity;

    public TableCreated(Table_ID table_id, Menu menu, Capacity capacity) {
        super("restaurante.waiter.tablecrated");
        this.table_id = table_id;
        this.menu = menu;
        this.capacity = capacity;
    }

    public Table_ID getTable_id() {
        return table_id;
    }

    public Menu getMenu() {
        return menu;
    }

    public Capacity getCapacity() {
        return capacity;
    }
}
