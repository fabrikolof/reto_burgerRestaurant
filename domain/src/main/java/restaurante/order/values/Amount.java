package restaurante.order.values;

import co.com.sofka.domain.generic.ValueObject;

import java.math.BigDecimal;
import java.util.Objects;

public class Amount implements ValueObject<Integer> {
    private final Integer value;

    public Amount(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Integer value() {
        return this.value;
    }
}
