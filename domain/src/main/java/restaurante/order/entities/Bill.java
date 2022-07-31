package restaurante.order.entities;

import co.com.sofka.domain.generic.Entity;
import restaurante.order.values.Details;
import restaurante.order.values.Amount;
import restaurante.order.values.Bill_ID;

public class Bill extends Entity<Bill_ID> {
    protected Details details;
    protected Amount amount;
    public Details getDetails() {
        return details;
    }

    public Amount getAmount() {
        return amount;
    }

    public Bill(Bill_ID bill_id, Details details, Amount amount) {
        super(bill_id);
        this.details = details;
        this.amount = amount;
    }
    public void updateDetails(Details details){
        this.details = details;
    }
}
