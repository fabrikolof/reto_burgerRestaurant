package restaurante.chef;

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
import restaurante.chef.commands.RemoveAssistance;
import restaurante.chef.events.AssistanceCreated;
import restaurante.chef.events.AssistanceRemoved;
import restaurante.chef.events.ChefCreated;
import restaurante.chef.values.Assistance_ID;
import restaurante.chef.values.Chef_ID;
import restaurante.chef.values.Name;
import restaurante.chef.values.PhoneNumber;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class RemoveAssistanceUseCaseTest {
    @InjectMocks
    private RemoveAssistanceUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void removeAssistanceSuccessfully() {

        Chef_ID fakeChef_ID = Chef_ID.of("fakeChef_ID");
        Assistance_ID fakeAssistanceID = Assistance_ID.of("fakeAssistanceID");

        var command = new RemoveAssistance(fakeChef_ID, fakeAssistanceID);

        Mockito.when(repository.getEventsBy("fakeChef_ID")).thenReturn(List.of(
                new ChefCreated(new Chef_ID("xxx"), new Name("Juan"), new PhoneNumber("123456")),
                new AssistanceCreated(Assistance_ID.of("fakeAssistanceID"), new Name("david"), new PhoneNumber("312987657")),
                new AssistanceCreated(Assistance_ID.of("anotherAssistance"), new Name("Luis"), new PhoneNumber("312777757"))
        ));

        useCase.addRepository(repository);

        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .setIdentifyExecutor("fakeChef_ID")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (AssistanceRemoved) domainEvents.get(0);
        assertEquals("fakeAssistanceID", event.getAssistance_id().value());
        assertTrue(event.getWasDeleted());
        Mockito.verify(repository).getEventsBy("fakeChef_ID");
    }
}
