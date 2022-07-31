package restaurante.waiter;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import restaurante.waiter.commands.CreateWaiter;
import restaurante.waiter.events.WaiterCreated;
import restaurante.waiter.values.Name;
import restaurante.waiter.values.PhoneNumber;
import restaurante.waiter.values.Waiter_ID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateWaiterUseCaseTest {
    @InjectMocks
    private CreateWaiterUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void CreateWaiterSuccefully() {
        //Arrage
        Waiter_ID waiter_id = Waiter_ID.of("fakeWaiterID");
        Name name = new Name("Adryan");
        PhoneNumber phoneNumber = new PhoneNumber("123456");
        var command = new CreateWaiter(waiter_id, name, phoneNumber);

        //Act (when)
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getWaiter_id().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (WaiterCreated) events.get(0);
        assertEquals("Adryan", event.getName().value());
        assertEquals("123456", event.getPhoneNumber().value());
        assertEquals("fakeWaiterID", event.getWaiter_id().value());
    }
}
