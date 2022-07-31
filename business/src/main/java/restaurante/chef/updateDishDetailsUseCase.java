package restaurante.chef;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import restaurante.chef.commands.updateDishDetails;

public class updateDishDetailsUseCase extends UseCase<RequestCommand<updateDishDetails>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<updateDishDetails> updateDishDetailsUseCaseRequestCommand) {
        var command = updateDishDetailsUseCaseRequestCommand.getCommand();
        var chef = Chef.from(command.getChef_id(), repository().getEventsBy(command.getChef_id().value()));
        chef.updateDishDetails(command.getDish_id(), command.getDetails());
        emit().onResponse(new ResponseEvents(chef.getUncommittedChanges()));
    }
}
