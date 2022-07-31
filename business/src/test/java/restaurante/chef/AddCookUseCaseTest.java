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
import restaurante.chef.commands.AddCook;
import restaurante.chef.events.AddedCook;
import restaurante.chef.events.ChefCreated;
import restaurante.chef.values.Chef_ID;
import restaurante.chef.values.Name;
import restaurante.chef.values.PhoneNumber;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddCookUseCaseTest {

    @InjectMocks
    private AddCookUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addCookToChefSuccefully() {
        //Arrage (given)
        Chef_ID chef_id = Chef_ID.of("fakeCookID");
        Name name = new Name("AdryanCook");
        PhoneNumber phoneNumber = new PhoneNumber("123456");
        //command folder
        var command = new AddCook(chef_id, name, phoneNumber);

        when(repository.getEventsBy("fakeCookID")).thenReturn(history());
        useCase.addRepository(repository);

        //Act (when)
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getChef_id().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (AddedCook) events.get(0);
        assertEquals("AdryanCook", event.getName().value());
        assertEquals("123456", event.getPhoneNumber().value());
        Mockito.verify(repository).getEventsBy("fakeCookID");
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
