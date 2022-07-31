package restaurante.chef;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import restaurante.chef.events.AddedDish;
import restaurante.chef.events.ChefCreated;
import restaurante.chef.events.ChefCreatedMessage;
import restaurante.chef.values.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ChefCreatedMessageUseCaseTest {
    @InjectMocks
    private ChefCreatedMessageUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void ChefCreatedMessageSuccefully() {
        //instance of AddedDish //Chef_ID chef_id, Name name, PhoneNumber phoneNumber
        var event = new ChefCreated(Chef_ID.of("123"), new Name("aaa"), new PhoneNumber("123445"));
        event.setAggregateRootId("xxx");

        when(repository.getEventsBy("xxx")).thenReturn(List.of(event));
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("xxx")
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var msg = (ChefCreatedMessage) events.get(0);
        assertEquals("Chef on duty", msg.getMessage());
    }
}
