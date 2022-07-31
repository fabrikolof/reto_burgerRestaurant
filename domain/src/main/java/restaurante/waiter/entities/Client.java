package restaurante.waiter.entities;

import co.com.sofka.domain.generic.Entity;
import restaurante.waiter.values.Name;
import restaurante.waiter.values.PhoneNumber;
import restaurante.waiter.values.Client_ID;

public class Client extends Entity<Client_ID> {
    protected Name name;
    protected PhoneNumber phoneNumber;

    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Client(Client_ID client_id, Name name, PhoneNumber phoneNumber) {
        super(client_id);
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void updateName(Name name){
        this.name = name;
    }
    public void updatePhoneNumber(PhoneNumber phoneNumber){
        this.phoneNumber = phoneNumber;
    }
}
