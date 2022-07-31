package restaurante.waiter;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import restaurante.waiter.commands.CreateNote;

public class CreateNoteUseCase extends UseCase<RequestCommand<CreateNote>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateNote> createNoteRequestCommand) {
        var command = createNoteRequestCommand.getCommand();
        var waiter = Waiter.from(command.getWaiter_id(), repository().getEventsBy(command.getWaiter_id().value()));
        waiter.createNote(command.getNote_id(), command.getClarifications(), command.getProducts());
        emit().onResponse(new ResponseEvents(waiter.getUncommittedChanges()));
    }
}
