package restaurante.waiter;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import restaurante.waiter.commands.AddClient;

public class AddClientUseCase extends UseCase<RequestCommand<AddClient>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddClient> addClientRequestCommand) {
        var command = addClientRequestCommand.getCommand();
        Waiter waiter = Waiter.from(command.getWaiter_id(), repository().getEventsBy(command.getClient_id().value()));
        waiter.addClient(command.getClient_id(), command.getName(), command.getPhoneNumber());
        emit().onResponse(new ResponseEvents(waiter.getUncommittedChanges()));
    }
}
