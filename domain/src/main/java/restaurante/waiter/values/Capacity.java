package restaurante.waiter.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Capacity implements ValueObject<Integer> {
    private final Integer value;

    public Capacity(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Integer value() {
        return this.value;
    }
}
