package restaurante.chef;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import restaurante.chef.commands.updateDishPrice;

public class updateDishPriceUseCase extends UseCase<RequestCommand<updateDishPrice>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<updateDishPrice> updateDishPriceRequestCommand) {
        var command = updateDishPriceRequestCommand.getCommand();
        var chef = Chef.from(command.getChef_id(), repository().getEventsBy(command.getChef_id().value()));
        chef.updateDishPrice(command.getDish_id(), command.getPrice());
        emit().onResponse(new ResponseEvents(chef.getUncommittedChanges()));
    }
}
