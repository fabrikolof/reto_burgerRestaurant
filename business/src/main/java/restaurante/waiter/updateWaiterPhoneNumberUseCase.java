package restaurante.waiter;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import restaurante.waiter.commands.updateWaiterPhoneNumber;

public class updateWaiterPhoneNumberUseCase extends UseCase<RequestCommand<updateWaiterPhoneNumber>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<updateWaiterPhoneNumber> updateWaiterPhoneNumberRequestCommand) {
        var command = updateWaiterPhoneNumberRequestCommand.getCommand();
        Waiter waiter = Waiter.from(command.getWaiter_id(), repository().getEventsBy(command.getWaiter_id().value()));
        waiter.updateWaiterPhoneNumber(command.getWaiter_id(), command.getPhoneNumber());
        emit().onResponse(new ResponseEvents(waiter.getUncommittedChanges()));
    }
}
