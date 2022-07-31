package restaurante.chef;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import restaurante.chef.commands.AddCook;

public class AddCookUseCase extends UseCase<RequestCommand<AddCook>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddCook> addCookRequestCommand) {
        var command = addCookRequestCommand.getCommand();

        Chef chef = Chef.from(command.getChef_id(), repository().getEventsBy(command.getChef_id().value()));

        chef.addCook(command.getName(), command.getPhoneNumber());

        emit().onResponse(new ResponseEvents(chef.getUncommittedChanges()));
    }
}
