package restaurante.order.values;

import co.com.sofka.domain.generic.Identity;

public class Food_ID extends Identity {
    public Food_ID(String id) {
        super(id);
    }
    public Food_ID() {}
    public static Food_ID of(String id) {
        return new Food_ID(id);
    }
}
