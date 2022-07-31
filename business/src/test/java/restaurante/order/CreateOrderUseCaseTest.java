package restaurante.order;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import restaurante.order.commands.CreateOrder;
import restaurante.order.entities.Bill;
import restaurante.order.events.OrderCreated;
import restaurante.order.values.*;

public class CreateOrderUseCaseTest {

    private CreateOrderUseCase useCase;

    @BeforeEach
    public void setup() {
        useCase = new CreateOrderUseCase();
    }

    @Test
    public void createOrderSuccefuly() {

        //Arrange
        Order_ID order_id = Order_ID.of("fakeOrderID");
        Date date = new Date(5,7, 2022);
        Bill_ID bill_id = new Bill_ID("fakeBillID");
        Details details = new Details("Order of the day");
        Amount amount = new Amount(500);
        Bill bill = new Bill(bill_id, details, amount);

        var command = new CreateOrder(order_id, date, bill);

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var chefCreated = (OrderCreated) events.get(0);
        Assertions.assertEquals(date, command.getDate());
        Assertions.assertEquals(500, command.getBill().getAmount().value());
        Assertions.assertEquals("Order of the day", command.getBill().getDetails().value());

    }
}