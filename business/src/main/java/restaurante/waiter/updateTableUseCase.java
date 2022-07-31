package restaurante.waiter;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import restaurante.waiter.commands.updateTable;

public class updateTableUseCase extends UseCase<RequestCommand<updateTable>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<updateTable> updateTableRequestCommand) {
        var command = updateTableRequestCommand.getCommand();
        var waiter = Waiter.from(command.getWaiter_id(), repository().getEventsBy(command.getWaiter_id().value()));
        waiter.updateTable(command.getTable_id(), command.getMenu(), command.getCapacity());
        emit().onResponse(new ResponseEvents(waiter.getUncommittedChanges()));
    }
}
