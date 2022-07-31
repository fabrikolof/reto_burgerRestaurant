package restaurante.chef;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import restaurante.chef.commands.AddDish;

public class AddDishUseCase extends UseCase<RequestCommand<AddDish>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddDish> addDishRequestCommand) {
        var command = addDishRequestCommand.getCommand();

        Chef chef = Chef.from(command.getChef_id(), repository().getEventsBy(command.getChef_id().value()));

        chef.addDish(command.getPrice(), command.getDetails());

        emit().onResponse(new ResponseEvents(chef.getUncommittedChanges()));
    }
}
