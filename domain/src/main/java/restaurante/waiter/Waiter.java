package restaurante.waiter;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import restaurante.waiter.commands.updateClientName;
import restaurante.waiter.events.*;
import restaurante.waiter.entities.Client;
import restaurante.waiter.entities.Note;
import restaurante.waiter.entities.Table;
import restaurante.waiter.values.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Waiter extends AggregateEvent<Waiter_ID> {
    protected Name name;
    protected PhoneNumber phoneNumber;
    protected Table table;
    protected Set<Client> clientSet;
    protected Note note;

    public Waiter(Waiter_ID waiter_id, Name name, PhoneNumber phoneNumber) {
        super(waiter_id);
        appendChange(new WaiterCreated(waiter_id, name, phoneNumber)).apply();
    }
    Waiter(Waiter_ID waiter_id) {
        super(waiter_id);
        subscribe(new WaiterChange(this));
    }
    public static Waiter from(Waiter_ID waiter_id, List<DomainEvent> domainEvents) {
        Waiter waiter = new Waiter(waiter_id);
        domainEvents.forEach(waiter::applyEvent);
        return waiter;
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
    //    findById
    public Optional<Client> findClientById(Client_ID client_id) {
        return this.clientSet.stream().filter(c -> c.identity().equals(client_id)).findFirst();
    }

    //Method
    public void addClient(Client_ID client_id, Name name, PhoneNumber phoneNumber){
        appendChange(new clientAdded(client_id, name, phoneNumber)).apply();
    }
    public void createNote(Note_ID note_id, Clarifications clarifications, Products products){
        appendChange(new noteCreated(note_id, clarifications, products)).apply();
    }
    public void createTable(Table_ID table_id, Menu menu, Capacity capacity){
        appendChange(new TableCreated(table_id, menu, capacity)).apply();
    }
    public void CreateWaiter(Waiter_ID waiter_id, Name name, PhoneNumber phoneNumber){
        appendChange(new WaiterCreated(waiter_id, name, phoneNumber)).apply();
    }
    public void updateClientName(Client_ID client_id, Name name){
        appendChange(new clientNameUpdated(client_id, name)).apply();
    }
    public void updateClientPhoneNumber(Client_ID client_id, PhoneNumber phoneNumber){
        appendChange(new clientPhoneNumberUpdated(client_id, phoneNumber)).apply();
    }
    public void updateMenuName(Table_ID table_id, Menu menu){
        appendChange(new menuNameUpdated(table_id, menu)).apply();
    }
    public void updateNoteClarifications(Note_ID note_id, Clarifications clarifications){
        appendChange(new noteClarificationsUpdated(note_id, clarifications)).apply();
    }
    public void updateNoteProducts(Note_ID note_id, Products products){
        appendChange(new noteProdutsUpdated(note_id, products)).apply();
    }
    public void updateTable(Table_ID table_id, Menu menu, Capacity capacity){
        appendChange(new TableUpdated(table_id, menu, capacity)).apply();
    }
    public void updateWaiterName(Waiter_ID waiter_id, Name name) {
        appendChange(new WaiterNameUpdated(waiter_id, name)).apply();
    }
    public void updateWaiterPhoneNumber(Waiter_ID waiter_id, PhoneNumber phoneNumber){
        appendChange(new WaiterPhoneNumberUpdated(waiter_id, phoneNumber)).apply();
    }


}
