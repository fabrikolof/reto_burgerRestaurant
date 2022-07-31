package restaurante.chef;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import restaurante.chef.commands.updateAssitancePhoneNumber;


public class updateAssitancePhoneNumberUseCase extends UseCase<RequestCommand<updateAssitancePhoneNumber>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<updateAssitancePhoneNumber> updateAssitancePhoneNumberRequestCommand) {
        var command = updateAssitancePhoneNumberRequestCommand.getCommand();
        var chef = Chef.from(command.getChef_id(), repository().getEventsBy(command.getChef_id().value()));
        chef.updateAssitancePhoneNumber(command.getAssistance_ID(), command.getPhoneNumber());
        emit().onResponse(new ResponseEvents(chef.getUncommittedChanges()));
    }
}
