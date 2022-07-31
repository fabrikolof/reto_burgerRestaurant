package restaurante.order;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import restaurante.chef.Chef;
import restaurante.chef.values.Chef_ID;
import restaurante.order.events.OrderCreated;

public class NotifyOrderCreatedUseCase extends UseCase<TriggeredEvent<OrderCreated>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<OrderCreated> orderCreatedTriggeredEvent) {
        var event = orderCreatedTriggeredEvent.getDomainEvent();
        var chef = Chef.from(Chef_ID.of(event.aggregateRootId()), this.retrieveEvents());
        chef.ChefCreatedMessage("Order sended");
        emit().onResponse(new ResponseEvents(chef.getUncommittedChanges()));
    }
}
