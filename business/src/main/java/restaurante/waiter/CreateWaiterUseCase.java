package restaurante.waiter;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import restaurante.waiter.commands.CreateWaiter;

public class CreateWaiterUseCase extends UseCase<RequestCommand<CreateWaiter>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateWaiter> createWaiterRequestCommand) {
        var command = createWaiterRequestCommand.getCommand();
        var waiter = new Waiter(command.getWaiter_id(), command.getName(), command.getPhoneNumber());
        emit().onResponse(new ResponseEvents(waiter.getUncommittedChanges()));
    }
}
