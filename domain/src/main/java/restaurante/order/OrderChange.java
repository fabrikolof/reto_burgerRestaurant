package restaurante.order;

import co.com.sofka.domain.generic.EventChange;
import restaurante.chef.events.ChefCreated;
import restaurante.order.events.OrderCreated;

import java.util.HashSet;

public class OrderChange extends EventChange {
    public OrderChange(Order order) {
        apply((OrderCreated event) -> {
            order.date = event.getDate();
            order.bill = event.getBill();
            order.foodSet = new HashSet<>();
            order.productSet = new HashSet<>();
        });
    }
}
