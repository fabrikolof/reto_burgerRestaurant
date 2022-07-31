package restaurante.waiter;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import restaurante.waiter.commands.updateClientName;
import restaurante.waiter.commands.updateClientPhoneNumber;

public class updateClientPhoneNumberUseCase extends UseCase<RequestCommand<updateClientPhoneNumber>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<updateClientPhoneNumber> updateClientPhoneNumberRequestCommand) {
        var command = updateClientPhoneNumberRequestCommand.getCommand();
        Waiter waiter = Waiter.from(command.getWaiter_id(), repository().getEventsBy(command.getWaiter_id().value()));
        waiter.updateClientPhoneNumber(command.getClient_ID(), command.getPhoneNumber());
        emit().onResponse(new ResponseEvents(waiter.getUncommittedChanges()));
    }
}
