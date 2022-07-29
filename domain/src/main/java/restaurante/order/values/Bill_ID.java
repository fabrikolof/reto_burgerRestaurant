package restaurante.order.values;

import co.com.sofka.domain.generic.Identity;

public class Bill_ID extends Identity {
    public Bill_ID(String id) {
        super(id);
    }
    public Bill_ID() {}
    public static Bill_ID of(String id) {
        return new Bill_ID(id);
    }
}
