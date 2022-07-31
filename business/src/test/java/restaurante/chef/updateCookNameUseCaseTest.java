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
import restaurante.chef.commands.updateCookName;
import restaurante.chef.events.*;
import restaurante.chef.values.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class updateCookNameUseCaseTest {
    @InjectMocks
    private updateCookNameUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateCookNameSuccefully() {

        //-----------
        Chef_ID chef_id = Chef_ID.of("fakeChefID");
        Cook_ID cook_id = Cook_ID.of("fakeCookID");
        Name name = new Name("davinchi");

        var command = new updateCookName(chef_id, cook_id, name);
        //-----------
        Mockito.when(repository.getEventsBy("fakeChefID")).thenReturn(List.of(
                new ChefCreated(chef_id, new Name("Juan"), new PhoneNumber("312777757")),
                new AddedCook(new Cook_ID("fakeCookID"), new Name("david"), new PhoneNumber("312987657"))
        ));

        useCase.addRepository(repository);

        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .setIdentifyExecutor("fakeChefID")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (CookNameUpdated) domainEvents.get(0);
        assertEquals("davinchi", event.getName().value());
        assertEquals("fakeCookID", event.getCook_ID().value());
        Mockito.verify(repository).getEventsBy("fakeChefID");

    }
}
