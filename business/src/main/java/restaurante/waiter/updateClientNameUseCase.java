package restaurante.waiter;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import restaurante.waiter.commands.updateClientName;

public class updateClientNameUseCase extends UseCase<RequestCommand<updateClientName>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<updateClientName> updateClientNameRequestCommand) {
        var command = updateClientNameRequestCommand.getCommand();
        var waiter = Waiter.from(command.getWaiter_ID(), repository().getEventsBy(command.getWaiter_ID().value()));
        waiter.updateClientName(command.getClient_ID(), command.getName());
        emit().onResponse(new ResponseEvents(waiter.getUncommittedChanges()));
    }
}
