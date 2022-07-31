package restaurante.waiter.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.waiter.values.Capacity;
import restaurante.waiter.values.Menu;
import restaurante.waiter.values.Table_ID;

public class updateTable extends Command {
    private final Table_ID table_id;
    private final Menu menu;
    private final Capacity capacity;

    public updateTable(Table_ID table_id, Menu menu, Capacity capacity) {
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
