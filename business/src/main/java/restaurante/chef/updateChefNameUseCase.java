package restaurante.chef;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import restaurante.chef.commands.updateChefName;

public class updateChefNameUseCase extends UseCase<RequestCommand<updateChefName>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<updateChefName> updateChefNameRequestCommand) {
        var command = updateChefNameRequestCommand.getCommand();

        Chef chef = Chef.from(command.getChef_id(), repository().getEventsBy(command.getChef_id().value()));

        chef.updateChefName(command.getChef_id(), command.getName());

        emit().onResponse(new ResponseEvents(chef.getUncommittedChanges()));
    }
}
