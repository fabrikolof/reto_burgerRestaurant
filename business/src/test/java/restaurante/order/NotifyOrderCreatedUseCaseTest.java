package restaurante.order;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import restaurante.chef.ChefCreatedMessageUseCase;
import restaurante.chef.events.ChefCreated;
import restaurante.chef.events.ChefCreatedMessage;
import restaurante.chef.values.Chef_ID;
import restaurante.chef.values.Name;
import restaurante.chef.values.PhoneNumber;
import restaurante.order.entities.Bill;
import restaurante.order.events.OrderCreated;
import restaurante.order.values.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotifyOrderCreatedUseCaseTest {
    @InjectMocks
    private NotifyOrderCreatedUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void NotifyOrderCreatedSuccefully() {
        var event = new OrderCreated(Order_ID.of("123"),
                new Date(20, 7, 2000),
                new Bill(Bill_ID.of("789"), new Details("details"), new Amount(500)));
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
        assertEquals("Order sended", msg.getMessage());
    }
}
