package restaurante.waiter;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import restaurante.waiter.commands.CreateTable;

public class CreateTableUseCase extends UseCase<RequestCommand<CreateTable>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateTable> createTableRequestCommand) {
        var command = createTableRequestCommand.getCommand();
        var waiter = Waiter.from(command.getWaiter_id(), repository().getEventsBy(command.getWaiter_id().value()));
        waiter.createTable(command.getTable_id(), command.getMenu(), command.getCapacity());
        emit().onResponse(new ResponseEvents(waiter.getUncommittedChanges()));
    }
}
