package restaurante.waiter;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import restaurante.waiter.commands.updateWaiterName;

public class updateWaiterNameUseCase extends UseCase<RequestCommand<updateWaiterName>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<updateWaiterName> updateWaiterNameRequestCommand) {
        var command = updateWaiterNameRequestCommand.getCommand();
        Waiter waiter = Waiter.from(command.getWaiter_id(), repository().getEventsBy(command.getWaiter_id().value()));
        waiter.updateWaiterName(command.getWaiter_id(), command.getName());
        emit().onResponse(new ResponseEvents(waiter.getUncommittedChanges()));
    }
}
