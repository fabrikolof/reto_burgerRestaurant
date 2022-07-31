package restaurante.waiter.events;


import co.com.sofka.domain.generic.DomainEvent;
import restaurante.waiter.values.Menu;
import restaurante.waiter.values.Table_ID;

public class menuNameUpdated extends DomainEvent {
    private final Table_ID table_id;
    private final Menu menu;

    public Table_ID getTable_id() {
        return table_id;
    }

    public Menu getMenu() {
        return menu;
    }

    public menuNameUpdated(Table_ID table_id, Menu menu) {
        super("restaurante.waiter.menunameupdated");
        this.table_id = table_id;
        this.menu = menu;
    }
}
