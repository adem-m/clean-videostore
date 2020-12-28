package com.esgi;

import java.util.ArrayList;
import java.util.List;

import static com.esgi.MovieType.*;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        this.rentals.add(rental);
    }

    public String getName() {
        return this.name;
    }

    public String createStatement() {
        Statement statement = new Statement();
        return statement.getStatement(this.rentals, this.name);
    }
}