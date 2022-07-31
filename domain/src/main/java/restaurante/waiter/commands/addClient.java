package restaurante.waiter.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.waiter.values.Client_ID;
import restaurante.waiter.values.Name;
import restaurante.waiter.values.PhoneNumber;

public class addClient extends Command {
    private final Client_ID trainerID;
    private final Name name;
    private final PhoneNumber phoneNumber;

    public addClient(Client_ID trainerID, Name name, PhoneNumber phoneNumber) {
        this.trainerID = trainerID;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Client_ID getTrainerID() {
        return trainerID;
    }

    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
