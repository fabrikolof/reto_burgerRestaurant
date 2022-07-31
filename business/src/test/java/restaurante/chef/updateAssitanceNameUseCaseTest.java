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
import restaurante.chef.commands.updateAssitanceName;
import restaurante.chef.events.AssistanceCreated;
import restaurante.chef.events.AssitanceNameUpdated;
import restaurante.chef.events.ChefCreated;
import restaurante.chef.values.Assistance_ID;
import restaurante.chef.values.Chef_ID;
import restaurante.chef.values.Name;
import restaurante.chef.values.PhoneNumber;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class updateAssitanceNameUseCaseTest {
    @InjectMocks
    private updateAssitanceNameUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateAssistanceNameSuccefully() {

        //-----------
        Chef_ID chef_id = Chef_ID.of("chef123");
        Assistance_ID assistance_id = Assistance_ID.of("assistance123");
        Name name = new Name("davinchi");

        var command = new updateAssitanceName(chef_id, assistance_id, name);
        //-----------
        Mockito.when(repository.getEventsBy("chef123")).thenReturn(List.of(
                new ChefCreated(chef_id, new Name("Juan"), new PhoneNumber("312777757")),
                new AssistanceCreated(new Assistance_ID("assistance123"), new Name("david"), new PhoneNumber("312987657"))
        ));
        //when(repository.getEventsBy("fakeChefID")).thenReturn(history());

        useCase.addRepository(repository);

        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .setIdentifyExecutor("chef123")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (AssitanceNameUpdated) domainEvents.get(0);
        assertEquals("davinchi", event.getName().value());
        assertEquals("assistance123", event.getAssistance_ID().value());
        Mockito.verify(repository).getEventsBy("chef123");

    }
/*    List<DomainEvent>history() {
        var ev1 = new ChefCreated(new Name("Juan"), new PhoneNumber("312777757"));
        ev1.setAggregateRootId("chef123");
        var ev2 = new AssistanceCreated(new Assistance_ID("assistance123"), new Name("david"), new PhoneNumber("312987657"));
        return List.of(ev1, ev2);
    }*/
}
