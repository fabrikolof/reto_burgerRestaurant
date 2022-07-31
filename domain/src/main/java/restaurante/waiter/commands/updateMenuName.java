package restaurante.waiter.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.waiter.values.Menu;
import restaurante.waiter.values.Table_ID;

public class updateMenuName extends Command {
    //A menu is in a table
    private final Table_ID table_id;
    private final Menu menu;

    public updateMenuName(Table_ID table_id, Menu menu) {
        this.table_id = table_id;
        this.menu = menu;
    }

    public Table_ID getTable_id() {
        return table_id;
    }

    public Menu getMenu() {
        return menu;
    }
}
