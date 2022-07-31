package restaurante.order.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.order.values.Amount;
import restaurante.order.values.Bill_ID;
import restaurante.order.values.Details;

public class BillCreated extends DomainEvent {
    private Bill_ID bill_id;
    private Details details;
    private Amount amount;

    public BillCreated(Bill_ID bill_id, Details details, Amount amount) {
        super("restaurante.order.billcreated");
        this.bill_id = bill_id;
        this.details = details;
        this.amount = amount;
    }

    public Bill_ID getBill_id() {
        return bill_id;
    }

    public Details getDetails() {
        return details;
    }

    public Amount getAmount() {
        return amount;
    }
}
