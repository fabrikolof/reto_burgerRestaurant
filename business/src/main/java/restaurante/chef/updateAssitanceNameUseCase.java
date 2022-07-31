package restaurante.chef;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import restaurante.chef.commands.updateAssitanceName;


public class updateAssitanceNameUseCase extends UseCase<RequestCommand<updateAssitanceName>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<updateAssitanceName> updateAssitanceNameRequestCommand) {
        var command = updateAssitanceNameRequestCommand.getCommand();
        var chef = Chef.from(command.getChef_id(), repository().getEventsBy(command.getChef_id().value()));
        chef.updateAssitanceName(command.getAssistance_ID(), command.getName());
        emit().onResponse(new ResponseEvents(chef.getUncommittedChanges()));
    }
}

