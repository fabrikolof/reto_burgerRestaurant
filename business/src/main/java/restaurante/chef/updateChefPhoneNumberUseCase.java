package restaurante.chef;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import restaurante.chef.commands.updateChefPhoneNumber;

public class updateChefPhoneNumberUseCase extends UseCase<RequestCommand<updateChefPhoneNumber>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<updateChefPhoneNumber> updateChefPhoneNumberRequestCommand) {
        var command = updateChefPhoneNumberRequestCommand.getCommand();

        Chef chef = Chef.from(command.getChef_ID(), repository().getEventsBy(command.getChef_ID().value()));

        chef.updateChefPhoneNumber(command.getChef_ID(), command.getPhoneNumber());

        emit().onResponse(new ResponseEvents(chef.getUncommittedChanges()));
    }
}
