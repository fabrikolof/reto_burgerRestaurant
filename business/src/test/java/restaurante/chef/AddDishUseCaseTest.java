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
import restaurante.chef.commands.AddDish;
import restaurante.chef.events.AddedDish;
import restaurante.chef.events.ChefCreated;
import restaurante.chef.values.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddDishUseCaseTest {
    @InjectMocks
    private AddDishUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addCookToChefSuccefully() {
        //Arrage (given)
        Chef_ID chef_id = Chef_ID.of("fakeDishID");
        Price price = new Price(500);
        Details details = new Details("Fideos con tuco");
        //command folder
        var command = new AddDish(chef_id, price, details);

        when(repository.getEventsBy("fakeDishID")).thenReturn(history());
        useCase.addRepository(repository);

        //Act (when)
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getChef_id().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (AddedDish) events.get(0);
        assertEquals(500, event.getPrice().value());
        assertEquals("Fideos con tuco", event.getDetails().value());
        Mockito.verify(repository).getEventsBy("fakeDishID");
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
