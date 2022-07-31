package restaurante.waiter.entities;

import co.com.sofka.domain.generic.Entity;
import restaurante.waiter.values.*;

public class Note extends Entity<Note_ID> {
    protected Clarifications clarifications;
    protected Products products;

    public Clarifications getClarifications() {
        return clarifications;
    }

    public Products getProducts() {
        return products;
    }

    public Note(Note_ID entityId, Clarifications clarifications, Products products) {
        super(entityId);
        this.clarifications = clarifications;
        this.products = products;
    }

    public void updateProducts(Products products){
        this.products = products;
    }
}
