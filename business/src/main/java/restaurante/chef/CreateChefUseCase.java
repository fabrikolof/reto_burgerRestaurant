package restaurante.chef;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import restaurante.chef.commands.CreateChef;

public class CreateChefUseCase extends UseCase<RequestCommand<CreateChef>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateChef> createChefRequestCommand) {
        var command = createChefRequestCommand.getCommand();
        var chef = new Chef(command.getChef_ID(), command.getName(), command.getPhoneNumber());
        emit().onResponse(new ResponseEvents(chef.getUncommittedChanges()));
    }
}