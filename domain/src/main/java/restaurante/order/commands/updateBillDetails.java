package restaurante.order.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.order.values.Amount;
import restaurante.order.values.Bill_ID;
import restaurante.order.values.Details;
import restaurante.order.values.Order_ID;

public class updateBillDetails extends Command {
    private Order_ID order_id;
    private Bill_ID bill_id;
    protected Details details;

    public Order_ID getOrder_id() {
        return order_id;
    }

    public Bill_ID getBill_id() {
        return bill_id;
    }

    public Details getDetails() {
        return details;
    }

    public updateBillDetails(Order_ID order_id, Bill_ID bill_id, Details details) {
        this.order_id = order_id;
        this.bill_id = bill_id;
        this.details = details;
    }
}
