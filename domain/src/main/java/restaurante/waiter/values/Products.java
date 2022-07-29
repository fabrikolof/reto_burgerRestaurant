package restaurante.waiter.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Products implements ValueObject<String> {
    private final String products;

    public Products(String products) {
        //TODO: validations
        this.products = Objects.requireNonNull(products);
    }

    @Override
    public String value() {
        return products;
    }
}
