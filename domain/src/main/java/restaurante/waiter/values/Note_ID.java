package restaurante.waiter.values;

import co.com.sofka.domain.generic.Identity;

public class Note_ID extends Identity {
    public Note_ID(String id) {
        super(id);
    }
    public Note_ID() {}
    public static Note_ID of(String id) {
        return new Note_ID(id);
    }
}
