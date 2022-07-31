package restaurante.waiter.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.waiter.values.Capacity;
import restaurante.waiter.values.Menu;
import restaurante.waiter.values.Table_ID;
import restaurante.waiter.values.Waiter_ID;

public class CreateTable extends Command {
    private Waiter_ID waiter_id;
    private Table_ID table_id;
    private Menu menu;
    private Capacity capacity;

    public CreateTable(Waiter_ID waiter_id, Table_ID table_id, Menu menu, Capacity capacity) {
        this.waiter_id = waiter_id;
        this.table_id = table_id;
        this.menu = menu;
        this.capacity = capacity;
    }

    public Waiter_ID getWaiter_id() {
        return waiter_id;
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
