package restaurante.waiter;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import restaurante.waiter.commands.updateMenuName;

public class updateMenuNameUseCase extends UseCase<RequestCommand<updateMenuName>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<updateMenuName> updateMenuNameRequestCommand) {
        var command = updateMenuNameRequestCommand.getCommand();
        var waiter = Waiter.from(command.getWaiter_id(), repository().getEventsBy(command.getWaiter_id().value()));
        waiter.updateMenuName(command.getTable_id(), command.getMenu());
        emit().onResponse(new ResponseEvents(waiter.getUncommittedChanges()));
    }
}
