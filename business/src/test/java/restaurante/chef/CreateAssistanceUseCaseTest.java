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
import restaurante.chef.commands.CreateAssistance;
import restaurante.chef.events.AssistanceCreated;
import restaurante.chef.events.ChefCreated;
import restaurante.chef.values.Assistance_ID;
import restaurante.chef.values.Chef_ID;
import restaurante.chef.values.Name;
import restaurante.chef.values.PhoneNumber;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateAssistanceUseCaseTest {

    @InjectMocks
    private CreateAssistanceUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addAssistanceToChefSuccefully() {
        //Arrage (given)
        Chef_ID chef_id = Chef_ID.of("fakeChefID");
        Assistance_ID assistance_id = Assistance_ID.of("123");
        Name name = new Name("Adryan");
        PhoneNumber phoneNumber = new PhoneNumber("123456");
        //command folder
        var command = new CreateAssistance(chef_id, assistance_id, name, phoneNumber);

        when(repository.getEventsBy("fakeChefID")).thenReturn(history());
        useCase.addRepository(repository);

        //Act (when)
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getChef_id().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (AssistanceCreated) events.get(0);
        assertEquals("Adryan", event.getName().value());
        assertEquals("123456", event.getPhoneNumber().value());
        Mockito.verify(repository).getEventsBy("fakeChefID");
    }

    private List<DomainEvent> history() {
        Chef_ID chef_id = Chef_ID.of("fakeChefID");
        Name name = new Name("Eddi");
        PhoneNumber phoneNumber = new PhoneNumber("987654321");
        var event = new ChefCreated(chef_id, name, phoneNumber);
        event.setAggregateRootId(chef_id.value());
        return List.of(event);
    }

}
