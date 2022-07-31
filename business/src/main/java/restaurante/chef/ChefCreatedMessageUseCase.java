package restaurante.chef;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import restaurante.chef.events.ChefCreated;
import restaurante.chef.values.Chef_ID;

//3 triggered per event
public class ChefCreatedMessageUseCase extends UseCase<TriggeredEvent<ChefCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<ChefCreated> chefCreatedTriggeredEvent) {
        var event = chefCreatedTriggeredEvent.getDomainEvent();
        var chef = Chef.from(Chef_ID.of(event.aggregateRootId()), this.retrieveEvents());
        chef.ChefCreatedMessage("Chef on duty");
        emit().onResponse(new ResponseEvents(chef.getUncommittedChanges()));
    }
}
