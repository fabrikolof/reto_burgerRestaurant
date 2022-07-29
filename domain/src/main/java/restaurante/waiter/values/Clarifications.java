package restaurante.waiter.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Clarifications implements ValueObject<String> {
    private final String clarifications;

    public Clarifications(String clarifications) {
        //TODO: validations
        this.clarifications = Objects.requireNonNull(clarifications);
    }

    @Override
    public String value() {
        return clarifications;
    }
}
