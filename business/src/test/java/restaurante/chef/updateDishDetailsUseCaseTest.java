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
import restaurante.chef.commands.updateDishDetails;
import restaurante.chef.events.AddedDish;
import restaurante.chef.events.ChefCreated;
import restaurante.chef.events.DishDetailsUpdated;
import restaurante.chef.values.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class updateDishDetailsUseCaseTest {
    @InjectMocks
    private updateDishDetailsUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void updateDishDetailsSuccefully() {
        //Arrage
        Chef_ID chef_id = Chef_ID.of("fakeChefID");
        Dish_ID dish_id = Dish_ID.of("fakeDishID");
        Details details = new Details("Pizza");

        var command = new updateDishDetails(chef_id, dish_id, details);

        //Act
        Mockito.when(repository.getEventsBy("fakeChefID")).thenReturn(List.of(
            new ChefCreated(chef_id, new Name("Roberto"), new PhoneNumber("456456456")),
                new AddedDish(new Dish_ID("fakeDishID"), new Price(500), new Details("Burger"))
        ));
        useCase.addRepository(repository);

        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .setIdentifyExecutor("fakeChefID")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (DishDetailsUpdated) domainEvents.get(0);
        assertEquals("Pizza", event.getDetails().value());
        assertEquals("fakeDishID", event.getDish_id().value());
        Mockito.verify(repository).getEventsBy("fakeChefID");
    }
}
