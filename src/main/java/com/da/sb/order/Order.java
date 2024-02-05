package com.da.sb.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name ="`Order`")
public class Order {

    private @Id
    @GeneratedValue Long id;

    private double price;
    private double quantity;
    private Side side;

    public Order(double price, double quantity, Side side) {
        this.price = price;
        this.quantity = quantity;
        this.side = side;
    }

    public Order() {
        super();
    }

    @Override
    public String toString() {
        return "%d : %s %f@%f".formatted(id, side.toString(), quantity, price);
    }

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

    public Side getSide() {
        return side;
    }
}
