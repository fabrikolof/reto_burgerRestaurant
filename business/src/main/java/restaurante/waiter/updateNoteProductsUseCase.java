package restaurante.waiter;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import restaurante.waiter.commands.updateNoteProducts;

public class updateNoteProductsUseCase extends UseCase<RequestCommand<updateNoteProducts>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<updateNoteProducts> updateNoteProductsRequestCommand) {
        var command = updateNoteProductsRequestCommand.getCommand();
        var waiter = Waiter.from(command.getWaiter_id(), repository().getEventsBy(command.getWaiter_id().value()));
        waiter.updateNoteProducts(command.getNote_id(), command.getProducts());
        emit().onResponse(new ResponseEvents(waiter.getUncommittedChanges()));
    }
}
