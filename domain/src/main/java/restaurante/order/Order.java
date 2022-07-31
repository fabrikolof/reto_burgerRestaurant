package restaurante.order;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import restaurante.chef.events.ChefCreatedMessage;
import restaurante.chef.values.*;
import restaurante.order.entities.Bill;
import restaurante.order.entities.Food;
import restaurante.order.entities.Product;
import restaurante.order.events.*;
import restaurante.order.values.*;
import restaurante.order.values.Details;
import restaurante.order.values.Price;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Order extends AggregateEvent<Order_ID> {

    protected Date date;
    protected Bill bill;
    protected Set<Food> foodSet;
    protected Set<Product> productSet;
    public Date getDate() {
        return date;
    }
    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Set<Food> getFoodSet() {
        return foodSet;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }
    public Order(Order_ID order_id, Date date, Bill bill) {
        super(order_id);
        appendChange(new OrderCreated(order_id, date, bill)).apply();//commands
    }
    Order(Order_ID order_id) {
        super(order_id);
        subscribe(new OrderChange(this));
    }
    public static Order from(Order_ID order_id, List<DomainEvent> domainEvents) {
        Order order = new Order(order_id);
        domainEvents.forEach(order::applyEvent);
        return order;
    }

    //    findById methods
    public Optional<Food> findFoodById(Food_ID food_id) {
        return this.foodSet.stream().filter(client -> client.identity().equals(food_id)).findFirst();
    }
    public Optional<Product> findProductById(Cook_ID cook_ID) {
        return this.productSet.stream().filter(cook -> cook.identity().equals(productSet)).findFirst();
    }

    //-----------------BILL
    public void createBill(Bill_ID bill_id, Details details, Amount amount) {
        appendChange(new BillCreated(bill_id, details, amount)).apply();
    }
    public void updateBillDetails(Bill_ID bill_id, Details details) {
        appendChange(new BillDetailsUpdated(bill_id, details)).apply();
    }
    //-----------------PRODUCT
    public void addProduct(Product_ID product_id, Price price, Quantity quantity, Details details) {
        appendChange(new ProductCreated(product_id, price, quantity, details)).apply();
    }
    public void updateProductDetails(Product_ID product_id, Details details) {
        appendChange(new ProductDetailsUpdated(product_id, details)).apply();
    }
    public void ChangeProductQuantity(Product_ID product_id, Quantity quantity) {
        appendChange(new ChangeProductQuantityUpdated(product_id, quantity)).apply();
    }
    //-----------------FOOD
    public void addFood(Food_ID food_id, Price price, Quantity quantity, Details details) {
        appendChange(new FoodCreated(food_id, price, quantity, details)).apply();
    }
    public void updateFoodDetails(Food_ID food_id, Details details) {
        appendChange(new FoodDetailsUpdated(food_id, details)).apply();
    }
    public void ChangeFoodQuantity(Food_ID food_id, Quantity quantity) {
        appendChange(new ChangeFoodQuantityUpdated(food_id, quantity)).apply();
    }
    //------------- use cases triggered per event
    public void notifyOrderCreated(String message) {
        appendChange(new NotifyOrderCreated(message)).apply();
    }
}
