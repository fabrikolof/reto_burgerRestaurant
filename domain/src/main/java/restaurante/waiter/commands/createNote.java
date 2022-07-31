package restaurante.waiter.commands;

import co.com.sofka.domain.generic.Command;
import restaurante.waiter.values.Clarifications;
import restaurante.waiter.values.Products;

public class createNote extends Command {
    protected Clarifications clarifications;
    protected Products products;

    public createNote(Clarifications clarifications, Products products) {
        this.clarifications = clarifications;
        this.products = products;
    }
    public Clarifications getClarifications() {
        return clarifications;
    }

    public Products getProducts() {
        return products;
    }
}
