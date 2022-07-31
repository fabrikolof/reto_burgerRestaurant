package restaurante.order.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Quantity implements ValueObject<Integer> {
    private final Integer value;

    public Quantity(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Integer value() {
        return this.value;
    }
}
