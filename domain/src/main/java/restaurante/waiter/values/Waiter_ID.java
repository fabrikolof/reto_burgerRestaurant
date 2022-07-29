package restaurante.waiter.values;

import co.com.sofka.domain.generic.Identity;

public class Waiter_ID extends Identity {
    public Waiter_ID(String id) {
        super(id);
    }
    public Waiter_ID() {}
    public static Waiter_ID of(String id) {
        return new Waiter_ID(id);
    }
}
