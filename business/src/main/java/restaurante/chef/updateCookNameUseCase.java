package restaurante.chef;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import restaurante.chef.commands.updateCookName;

public class updateCookNameUseCase extends UseCase<RequestCommand<updateCookName>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<updateCookName> updateCookNameRequestCommand) {
        var command = updateCookNameRequestCommand.getCommand();
        var chef = Chef.from(command.getChef_id(), repository().getEventsBy(command.getChef_id().value()));
        chef.updateCookName(command.getCook_ID(), command.getName());
        emit().onResponse(new ResponseEvents(chef.getUncommittedChanges()));
    }
}
