package restaurante.order.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Payment_type implements ValueObject<String> {

    private final String CREDITCARD = "CREDITCARD";
    private final String EFFECTIVE = "EFFECTIVE";
    private final String CARD = "CARD";

    private final String payment_type;

        public Payment_type(String payment_type) {
            if(!dataValidation(payment_type)){
                errorHandler();
            }
            this.payment_type = Objects.requireNonNull(payment_type);

            //TODO: validations
            //this.payment_type = Objects.requireNonNull(payment_type);
        }

        public void errorHandler(){
            throw new IllegalArgumentException("The method for paying is not valid.");
        }

        public boolean dataValidation(String payment_type){
            return (payment_type == "CREDITCARD") ? true : (payment_type == "EFFECTIVE") ? true : (payment_type == "CARD") ? true : false;
        }

        @Override
        public String value() {
            return payment_type;
        }

/*    public static void main(String[] args) {
        Payment_type test = new Payment_type("CREDITCARD");
        System.out.println(test.value());
    }*/
}
