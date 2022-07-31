package restaurante.chef;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import restaurante.chef.commands.CreateAssistance;

//AddClientUseCase create = asdd
public class CreateAssistanceUseCase extends UseCase<RequestCommand<CreateAssistance>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateAssistance> createAssistanceRequestCommand) {
        var command = createAssistanceRequestCommand.getCommand();

        Chef chef = Chef.from(command.getChef_id(), repository().getEventsBy(command.getChef_id().value()));

        chef.addAssistance(command.getName(), command.getPhoneNumber());

        emit().onResponse(new ResponseEvents(chef.getUncommittedChanges()));
    }
}
