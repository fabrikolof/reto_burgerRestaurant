package restaurante.waiter.values;

import co.com.sofka.domain.generic.Identity;
import restaurante.order.values.Product_ID;

public class Client_ID extends Identity {
    public Client_ID(String id) {
        super(id);
    }
    public Client_ID() {}
    public static Client_ID of(String id) {
        return new Client_ID(id);
    }
}
