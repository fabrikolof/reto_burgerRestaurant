package restaurante.chef;

import co.com.sofka.domain.generic.EventChange;
import restaurante.chef.entities.Assitance;
import restaurante.chef.entities.Cook;
import restaurante.chef.entities.Dish;
import restaurante.chef.events.*;
import restaurante.chef.values.Assistance_ID;

import java.util.HashSet;
public class ChefChange extends EventChange {
    public ChefChange(Chef chef) {
        //Chef events
        apply((ChefCreated event) -> {
            chef.name = event.getName();
            chef.phoneNumber = event.getPhoneNumber();
            chef.assitanceSet = new HashSet<>();
            chef.dishesSet = new HashSet<>();
            chef.cooksSet = new HashSet<>();
        });
        //apply((UpdatedName event) -> entity.name = event.getNewName());
        apply((ChefNameUpdated event) -> {
            chef.name = event.getName();
        });
        apply((ChefPhoneNumberUpdated event) -> {
            chef.phoneNumber = event.getPhoneNumber();
        });
        //Assistance events -- AssistanceCreated = assistanceAdded
        apply((AssistanceCreated event) -> {
            Assitance assitance = new Assitance(event.getAssistance_id(), event.getName(), event.getPhoneNumber());
            chef.getAssitanceSet().add(assitance);
        });
        apply((AssitanceNameUpdated event) -> {
            Assitance assistance = chef.findAssitanceById(event.getAssistance_ID()).orElseThrow();
            assistance.updateName(event.getName());
        });
        apply((AssistancePhoneNumberUpdated event) -> {
            Assitance assistance = chef.findAssitanceById(event.getAssistance_ID()).orElseThrow();
            assistance.updatePhoneNumber(event.getPhoneNumber());
        });
        //Cook events
        apply((AddedCook event) -> {
            Cook cook = new Cook(event.getCook_id(), event.getName(), event.getPhoneNumber());
            chef.getCookSet().add(cook);
        });
        apply((CookNameUpdated event) -> {
            Cook cook = chef.findCookById(event.getCook_ID()).orElseThrow();
            cook.updateName(event.getName());
        });
        apply((CookPhoneNumberUpdated event) -> {
            Cook cook = chef.findCookById(event.getCook_ID()).orElseThrow();
            cook.updatePhoneNumber(event.getPhoneNumber());
        });
        //Dish events
        apply((AddedDish event) -> {
            Dish dish = new Dish(event.getDish_id(), event.getPrice(), event.getDetails());
            chef.getDishSet().add(dish);
        });
        apply((DishDetailsUpdated event) -> {
            Dish dish = chef.findDishById(event.getDish_id()).orElseThrow();
            dish.updateDetails(event.getDetails());
        });
        apply((DishPriceUpdated event) -> {
            Dish dish = chef.findDishById(event.getDish_id()).orElseThrow();
            dish.updatePrice(event.getPrice());
        });
        //Finders chef.findAssitanceById(assistance_id) x3

    }
}
