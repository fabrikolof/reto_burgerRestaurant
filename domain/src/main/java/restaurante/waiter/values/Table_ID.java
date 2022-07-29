package restaurante.waiter.values;

import co.com.sofka.domain.generic.Identity;

public class Table_ID extends Identity {
    public Table_ID(String id) {
        super(id);
    }
    public Table_ID() {}
    public static Table_ID of(String id) {
        return new Table_ID(id);
    }
}
