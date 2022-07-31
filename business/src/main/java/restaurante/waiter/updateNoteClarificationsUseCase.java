package restaurante.waiter;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import restaurante.waiter.commands.updateNoteClarifications;

public class updateNoteClarificationsUseCase extends UseCase<RequestCommand<updateNoteClarifications>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<updateNoteClarifications> updateNoteClarificationsRequestCommand) {
        var command = updateNoteClarificationsRequestCommand.getCommand();
        var waiter = Waiter.from(command.getWaiter_id(), repository().getEventsBy(command.getWaiter_id().value()));
        waiter.updateNoteClarifications(command.getNote_id(), command.getClarifications());
        emit().onResponse(new ResponseEvents(waiter.getUncommittedChanges()));
    }
}
