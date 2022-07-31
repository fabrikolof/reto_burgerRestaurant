package restaurante.waiter;

import co.com.sofka.domain.generic.EventChange;
import restaurante.waiter.events.WaiterCreated;

import java.util.HashSet;

public class WaiterChange extends EventChange {

    public WaiterChange(Waiter waiter){
        apply((WaiterCreated event) -> {
           waiter.name = event.getName();
           waiter.phoneNumber = event.getPhoneNumber();
           waiter.clientSet = new HashSet<>();
        });
    }
}
