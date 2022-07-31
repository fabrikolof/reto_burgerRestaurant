package restaurante.order.entities;

import co.com.sofka.domain.generic.Entity;
import restaurante.order.values.Details;
import restaurante.order.values.Price;
import restaurante.order.values.Product_ID;
import restaurante.order.values.Quantity;

public class Product extends Entity<Product_ID> {
    protected Price price;
    protected Quantity quantity;
    protected Details details;

    public Price getPrice() {
        return price;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public Details getDetails() {
        return details;
    }

    public Product(Product_ID entityId, Price price, Quantity quantity, Details details) {
        super(entityId);
        this.price = price;
        this.quantity = quantity;
        this.details = details;
    }
    public void updateQuantity(Quantity quantity){
        this.quantity = quantity;
    }
}
