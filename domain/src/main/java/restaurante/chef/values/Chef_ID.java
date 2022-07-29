package restaurante.chef.values;

import co.com.sofka.domain.generic.Identity;

public class Chef_ID extends Identity {
    public Chef_ID(String id) {
        super(id);
    }
    public Chef_ID() {}
    public static Chef_ID of(String id) {
        return new Chef_ID(id);
    }
}
