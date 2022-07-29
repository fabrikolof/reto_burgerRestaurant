package restaurante.chef.values;

import co.com.sofka.domain.generic.Identity;

public class Cook_ID extends Identity {
    public Cook_ID(String id) {
        super(id);
    }
    public Cook_ID() {}
    public static Cook_ID of(String id) {
        return new Cook_ID(id);
    }
}
