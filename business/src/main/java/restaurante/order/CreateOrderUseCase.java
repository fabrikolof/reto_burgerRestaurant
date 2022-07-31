package restaurante.order;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import restaurante.order.commands.CreateOrder;

public class CreateOrderUseCase extends UseCase<RequestCommand<CreateOrder>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateOrder> createOrderRequestCommand) {
        var command = createOrderRequestCommand.getCommand();
        var order = new Order(command.getOrder_id(), command.getDate(), command.getBill());
        emit().onResponse(new ResponseEvents(order.getUncommittedChanges()));
    }
}
