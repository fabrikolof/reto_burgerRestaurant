package restaurante.order.events;

import co.com.sofka.domain.generic.DomainEvent;
import restaurante.order.entities.Bill;
import restaurante.order.values.Date;
import restaurante.order.values.Order_ID;

public class OrderCreated extends DomainEvent {
    private Order_ID order_id;
    private Date date;
    private Bill bill;
    public OrderCreated(Order_ID order_id, Date date, Bill bill) {
        super("restaurante.order.ordercreated");
        this.order_id = order_id;
        this.date = date;
        this.bill = bill;
    }

    public Order_ID getOrder_id() {
        return order_id;
    }

    public Date getDate() {
        return date;
    }

    public Bill getBill() {
        return bill;
    }

}
