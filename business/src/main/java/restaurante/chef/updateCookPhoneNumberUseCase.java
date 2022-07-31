package restaurante.chef;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import restaurante.chef.commands.updateCookPhoneNumber;

public class updateCookPhoneNumberUseCase extends UseCase<RequestCommand<updateCookPhoneNumber>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<updateCookPhoneNumber> updateCookPhoneNumberRequestCommand) {
        var command = updateCookPhoneNumberRequestCommand.getCommand();
        var chef = Chef.from(command.getChef_id(), repository().getEventsBy(command.getChef_id().value()));
        chef.updateCookPhoneNumber(command.getCook_ID(), command.getPhoneNumber());
        emit().onResponse(new ResponseEvents(chef.getUncommittedChanges()));
    }
}
