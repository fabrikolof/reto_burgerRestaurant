package restaurante.waiter.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Menu implements ValueObject<String> {
    private final String menu;

    public Menu(String menu) {
        //TODO: validations
        this.menu = Objects.requireNonNull(menu);
    }

    @Override
    public String value() {
        return menu;
    }
}
