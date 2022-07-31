package restaurante.chef;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import restaurante.chef.commands.CreateChef;
import restaurante.chef.events.ChefCreated;
import restaurante.chef.values.Chef_ID;
import restaurante.chef.values.Name;
import restaurante.chef.values.PhoneNumber;

public class CreateChefUseCaseTest {

    private CreateChefUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CreateChefUseCase();
    }

    @Test
    public void createChef(){

        //Arrange
        Chef_ID chef_id = Chef_ID.of("xxxxx");
        Name name = new Name("Adryan");
        PhoneNumber phoneNumber = new PhoneNumber("stringNumber123");
        var command = new CreateChef( chef_id,  name,  phoneNumber);

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var chefCreated = (ChefCreated)events.get(0);
        Assertions.assertEquals("xxxxx", chefCreated.aggregateRootId());
        Assertions.assertEquals("Adryan", chefCreated.getName().value());
        Assertions.assertEquals("stringNumber123", chefCreated.getPhoneNumber().value());

        //Assertions.assertEquals("stringNumber123", chefCreated.get().value());

    }
}
