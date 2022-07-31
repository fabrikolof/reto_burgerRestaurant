package restaurante.order.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.order.values.Amount;
import restaurante.order.values.Bill_ID;
import restaurante.order.values.Details;
import restaurante.order.values.Order_ID;

public class createBill extends Command {
    private Order_ID order_id;
    private Bill_ID bill_id;
    protected Details details;
    protected Amount amount;

    public Order_ID getOrder_id() {
        return order_id;
    }

    public Details getDetails() {
        return details;
    }

    public Amount getAmount() {
        return amount;
    }

    public createBill(Order_ID order_id, Bill_ID bill_id, Details details, Amount amount) {
        this.order_id = order_id;
        this.bill_id = bill_id;
        this.details = details;
        this.amount = amount;
    }
}
