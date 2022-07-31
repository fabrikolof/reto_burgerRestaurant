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
import restaurante.chef.commands.updateDishPrice;
import restaurante.chef.events.AddedDish;
import restaurante.chef.events.ChefCreated;
import restaurante.chef.events.DishPriceUpdated;
import restaurante.chef.values.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class updateDishPriceUseCaseTest {
    @InjectMocks
    private updateDishPriceUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void updateDishPriceSuccefully() {
        //Arrage
        Chef_ID chef_id = Chef_ID.of("fakeChefID");
        Dish_ID dish_id = Dish_ID.of("fakeDishID");
        Price price = new Price(500);

        var command = new updateDishPrice(chef_id, dish_id, price);

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

        var event = (DishPriceUpdated) domainEvents.get(0);
        assertEquals(500, event.getPrice().value());
        assertEquals("fakeDishID", event.getDish_id().value());
        Mockito.verify(repository).getEventsBy("fakeChefID");
    }
}
