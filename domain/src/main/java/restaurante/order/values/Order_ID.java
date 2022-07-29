package restaurante.order.values;

import co.com.sofka.domain.generic.Identity;

public class Order_ID extends Identity {
    public Order_ID(String id) {
        super(id);
    }
    public Order_ID() {}
    public static Order_ID of(String id) {
        return new Order_ID(id);
    }
}
