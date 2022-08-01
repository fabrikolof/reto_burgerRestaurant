package restaurante.chef;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import restaurante.chef.commands.RemoveAssistance;

public class RemoveAssistanceUseCase extends UseCase<RequestCommand<RemoveAssistance>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<RemoveAssistance> removeAssistanceRequestCommand) {
        var command = removeAssistanceRequestCommand.getCommand();
        Chef chef = Chef.from(command.getChef_id(), repository().getEventsBy(command.getChef_id().value()));
        chef.removeAssistance(command.getAssistance_id());
        emit().onResponse(new ResponseEvents(chef.getUncommittedChanges()));
    }
}
