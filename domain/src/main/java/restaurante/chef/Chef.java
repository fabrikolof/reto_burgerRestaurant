package restaurante.chef;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import restaurante.chef.entities.Assitance;
import restaurante.chef.entities.Cook;
import restaurante.chef.entities.Dish;
import restaurante.chef.events.*;
import restaurante.chef.values.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Chef extends AggregateEvent<Chef_ID> {
    protected Name name;
    protected PhoneNumber phoneNumber;
    protected Set<Assitance> assitanceSet;
    protected Set<Cook> cooksSet;
    //Set<Order> waiter -> order -> add to Set
    protected Set<Dish> dishesSet;

    public Chef(Chef_ID chef_ID, Name name, PhoneNumber phoneNumber) {
        super(chef_ID);
        appendChange(new ChefCreated(chef_ID, name, phoneNumber)).apply();
    }
    Chef(Chef_ID chef_ID) {
        super(chef_ID);
        subscribe(new ChefChange(this));
    }
    public static Chef from(Chef_ID chef_ID, List<DomainEvent> domainEvents) {
        Chef chef = new Chef(chef_ID);
        domainEvents.forEach(chef::applyEvent);
        return chef;
    }
    //    findById methods
    public Optional<Assitance> findAssitanceById(Assistance_ID assistance_ID) {
        return this.assitanceSet.stream().filter(client -> client.identity().equals(assistance_ID)).findFirst();
    }
    public Optional<Cook> findCookById(Cook_ID cook_ID) {
        return this.cooksSet.stream().filter(cook -> cook.identity().equals(cook_ID)).findFirst();
    }
    public Optional<Dish> findDishById(Dish_ID dish_ID) {
        return this.dishesSet.stream().filter(dish -> dish.identity().equals(dish_ID)).findFirst();
    }
    public Name getName() {
        return name;
    }
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
    public Set<Assitance> getAssitanceSet() {
        return assitanceSet;
    }
    public Set<Cook> getCookSet() {
        return cooksSet;
    }
    public Set<Dish> getDishSet() {
        return dishesSet;
    }
    //          EVENTS
    public void updateChefName(Chef_ID chef_id, Name name) {
        appendChange(new ChefNameUpdated(chef_id, name)).apply();
    }
    public void updateChefPhoneNumber(Chef_ID chef_id, PhoneNumber phoneNumber) {
        appendChange(new ChefPhoneNumberUpdated(chef_id, phoneNumber)).apply();
    }
    //-----------------ASSISTANCE
    public void addAssistance(Name name, PhoneNumber phoneNumber) {
        Assistance_ID assistance_id = new Assistance_ID();
        appendChange(new AssistanceCreated(assistance_id, name, phoneNumber)).apply();
    }
    public void removeAssistance(Assistance_ID assistance_id) {
        appendChange(new AssistanceRemoved(assistance_id)).apply();
    }
    public void updateAssitanceName(Assistance_ID assistance_id, Name name) {
        appendChange(new AssitanceNameUpdated(assistance_id, name)).apply();
    }
    public void updateAssitancePhoneNumber(Assistance_ID assistance_id, PhoneNumber phoneNumber) {
        appendChange(new AssistancePhoneNumberUpdated(assistance_id, phoneNumber)).apply();
    }

    //-----------------COOK
    public void addCook(Name name, PhoneNumber phoneNumber) {
        Cook_ID cook_id = new Cook_ID();
        appendChange(new AddedCook(cook_id, name, phoneNumber)).apply();
    }
    public void updateCookName(Cook_ID cook_id, Name name) {
        appendChange(new CookNameUpdated(cook_id, name)).apply();
    }
    public void updateCookPhoneNumber(Cook_ID cook_id, PhoneNumber phoneNumber) {
        appendChange(new CookPhoneNumberUpdated(cook_id, phoneNumber)).apply();
    }
    //-----------------DISH
    public void addDish(Price price, Details details) {
        Dish_ID dish_id = new Dish_ID();
        appendChange(new AddedDish(dish_id, price, details)).apply();
    }
    public void updateDishDetails(Dish_ID dish_id, Details details) {
        appendChange(new DishDetailsUpdated(dish_id, details)).apply();
    }
    public void updateDishPrice(Dish_ID dish_id, Price price) {
        appendChange(new DishPriceUpdated(dish_id, price)).apply();
    }
    //------------- use cases triggered per event
        //2 triggered per event
    public void ChefCreatedMessage(String message) {
        appendChange(new ChefCreatedMessage(message)).apply();
    }

}
