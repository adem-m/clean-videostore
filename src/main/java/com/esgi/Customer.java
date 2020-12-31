package com.esgi;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void addRental(Rental rental) {
        this.rentals.add(rental);
    }
}