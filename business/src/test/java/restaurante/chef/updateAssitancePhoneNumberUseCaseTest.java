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
import restaurante.chef.commands.updateAssitancePhoneNumber;
import restaurante.chef.events.AssistanceCreated;
import restaurante.chef.events.AssistancePhoneNumberUpdated;
import restaurante.chef.events.ChefCreated;
import restaurante.chef.values.Assistance_ID;
import restaurante.chef.values.Chef_ID;
import restaurante.chef.values.Name;
import restaurante.chef.values.PhoneNumber;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class updateAssitancePhoneNumberUseCaseTest {
    @InjectMocks
    private updateAssitancePhoneNumberUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateAssistancePhoneNumberSuccefully() {

        //-----------
        Chef_ID chef_id = Chef_ID.of("fakeChefID");
        Assistance_ID assistance_id = Assistance_ID.of("fakeAssistanceID");
        PhoneNumber phoneNumber = new PhoneNumber("56465487");

        var command = new updateAssitancePhoneNumber(chef_id, assistance_id, phoneNumber);
        //-----------
        Mockito.when(repository.getEventsBy("fakeChefID")).thenReturn(List.of(
                new ChefCreated(chef_id, new Name("Juan"), new PhoneNumber("312777757")),
                new AssistanceCreated(new Assistance_ID("fakeAssistanceID"), new Name("david"), new PhoneNumber("312987657"))
        ));

        useCase.addRepository(repository);

        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .setIdentifyExecutor("fakeChefID")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (AssistancePhoneNumberUpdated) domainEvents.get(0);
        assertEquals("56465487", event.getPhoneNumber().value());
        assertEquals("fakeAssistanceID", event.getAssistance_ID().value());
        Mockito.verify(repository).getEventsBy("fakeChefID");

    }
}