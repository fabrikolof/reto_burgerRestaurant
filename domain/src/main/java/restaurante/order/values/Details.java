package restaurante.order.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Details implements ValueObject<String> {
    private final String details;

    public Details(String details) {
        //TODO: validations
        this.details = Objects.requireNonNull(details);
    }

    @Override
    public String value() {
        return details;
    }

}
