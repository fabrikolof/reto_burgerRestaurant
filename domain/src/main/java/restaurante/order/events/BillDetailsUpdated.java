package restaurante.order.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.order.values.Bill_ID;
import restaurante.order.values.Details;

public class BillDetailsUpdated extends DomainEvent {
    private Bill_ID bill_id;
    private Details details;

    public BillDetailsUpdated(Bill_ID bill_id, Details details) {
        super("restaurante.order.billdetailsupdated");
        this.bill_id = bill_id;
        this.details = details;
    }

    public Bill_ID getBill_id() {
        return bill_id;
    }

    public Details getDetails() {
        return details;
    }
}
