package restaurante.order.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Date implements ValueObject<String> {
    private final LocalDate date;
    private final String format;

    public Date(int day, int month, int year) {//(2)
        try {
            date = LocalDate.of(year, month, day);
            if(date.isAfter(LocalDate.now())){
                throw new IllegalArgumentException("No valid the date of birth");
            }
        } catch (DateTimeException e){
            throw new IllegalArgumentException(e.getMessage());
        }
        format = generateFormat();
    }

    private String generateFormat(){
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    @Override
    public String value() {//(3)
        return format;
    }

    @Override
    public boolean equals(Object o) {//(4)
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date that = (Date) o;
        return Objects.equals(format, that.format);
    }

    @Override
    public int hashCode() {//(5)
        return Objects.hash(format);
    }

/*    public static void main(String[] args) {
        Date test = new Date(12, 07, 2021);
        System.out.println(test.value());
    }*/
}
