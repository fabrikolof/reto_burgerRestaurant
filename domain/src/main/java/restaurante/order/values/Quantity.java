package restaurante.order.values;

import co.com.sofka.domain.generic.ValueObject;

import java.math.BigDecimal;
import java.util.Objects;

public class Quantity implements ValueObject<BigDecimal> {
    private final BigDecimal value;

    public Quantity(BigDecimal value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public BigDecimal value() {
        return this.value;
    }
}
