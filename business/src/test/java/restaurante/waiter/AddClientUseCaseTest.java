package restaurante.waiter;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import restaurante.waiter.commands.AddClient;
import restaurante.waiter.events.WaiterCreated;
import restaurante.waiter.events.clientAdded;
import restaurante.waiter.values.Client_ID;
import restaurante.waiter.values.Name;
import restaurante.waiter.values.PhoneNumber;
import restaurante.waiter.values.Waiter_ID;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddClientUseCaseTest {

    @InjectMocks
    private AddClientUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addClientSuccefully() {
        //Arrage (given)
        Waiter_ID waiter_id = Waiter_ID.of("fakeWaiterID");
        Client_ID client_id = Client_ID.of("fakeClientID");
        Name name = new Name("Adryan");
        PhoneNumber phoneNumber = new PhoneNumber("123456");
        //command folder
        var command = new AddClient(waiter_id, client_id, name, phoneNumber);

        when(repository.getEventsBy("fakeClientID")).thenReturn(history());
        useCase.addRepository(repository);

        //Act (when)
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getClient_id().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (clientAdded) events.get(0);
        assertEquals("Adryan", event.getName().value());
        assertEquals("123456", event.getPhoneNumber().value());
        Mockito.verify(repository).getEventsBy("fakeClientID");
    }

    private List<DomainEvent> history() {
        Waiter_ID waiter_id = Waiter_ID.of("fakeClientID");
        Name name = new Name("Eddi");
        PhoneNumber phoneNumber = new PhoneNumber("987654321");
        var event = new WaiterCreated(waiter_id, name, phoneNumber);
        event.setAggregateRootId(waiter_id.value());
        return List.of(event);
    }

}
