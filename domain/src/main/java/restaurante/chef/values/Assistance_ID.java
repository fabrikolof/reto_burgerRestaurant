package restaurante.chef.values;

import co.com.sofka.domain.generic.Identity;

public class Assistance_ID extends Identity {
    public Assistance_ID(String id) {
        super(id);
    }
    public Assistance_ID() {}
    public static Assistance_ID of(String id) {
        return new Assistance_ID(id);
    }
}
