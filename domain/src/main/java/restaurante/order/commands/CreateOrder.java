package restaurante.order.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.order.entities.Bill;
import restaurante.order.values.Date;
import restaurante.order.values.Order_ID;

public class CreateOrder extends Command {
    private Order_ID order_id;
    private Date date;
    private Bill bill;

    public Order_ID getOrder_id() {
        return order_id;
    }

    public Date getDate() {
        return date;
    }

    public Bill getBill() {
        return bill;
    }

    public CreateOrder(Order_ID order_id, Date date, Bill bill) {
        this.order_id = order_id;
        this.date = date;
        this.bill = bill;
    }

}
