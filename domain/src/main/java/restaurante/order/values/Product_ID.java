package restaurante.order.values;

import co.com.sofka.domain.generic.Identity;

public class Product_ID extends Identity {
    public Product_ID(String id) {
        super(id);
    }
    public Product_ID() {}
    public static Product_ID of(String id) {
        return new Product_ID(id);
    }
}
