package restaurante.waiter.entities;

import co.com.sofka.domain.generic.Entity;
import restaurante.waiter.values.*;

public class Table extends Entity<Table_ID> {
    protected Menu menu;
    protected Capacity capacity;

    public Menu getMenu() {
        return menu;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public Table(Table_ID entityId, Menu menu, Capacity capacity) {
        super(entityId);
        this.menu = menu;
        this.capacity = capacity;
    }

    public void updateCapacity(Capacity capacity){
        this.capacity = capacity;
    }
    public void updateMenu(Menu menu){
        this.menu = menu;
    }
}
