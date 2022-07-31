package restaurante.waiter;

import co.com.sofka.domain.generic.AggregateEvent;
import restaurante.waiter.entities.Client;
import restaurante.waiter.entities.Note;
import restaurante.waiter.entities.Table;
import restaurante.waiter.values.*;

import java.util.Set;

public class Waiter extends AggregateEvent<Waiter_ID> {
    protected Name name;
    protected PhoneNumber phoneNumber;
    protected Table table;
    protected Set<Client> clientSet;
    protected Note note;

    public Waiter(Waiter_ID waiter_id, Name name, PhoneNumber phoneNumber, Table table, Set<Client> clientSet, Note note) {
        super(waiter_id);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.table = table;
        this.clientSet = clientSet;
        this.note = note;
    }

    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Table getTable() {
        return table;
    }

    public Set<Client> getClientSet() {
        return clientSet;
    }

    public Note getNote() {
        return note;
    }

    //Method
    public void updateWaiterName(){}
    public void updateWaiterPhoneNumber(){}
    public void updateTable(){}
    public void addClient(){}
    public void createNote(){}
    public void createOrder(){}
    public void updateClientName(){}
    public void updateClientPhoneNumber(){}
    public void updateMenu(){}
    public void updateNoteClarifications(){}
    public void updateNoteProducts(){}
    public void addCapacityToTable(){}
    public void removeCapacityToTable(){}

}
