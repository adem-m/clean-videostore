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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder();

        result.append(this.createStatementHeader(this.getName()));

        for (Rental rental : this.rentals) {
            double amount = this.getAmountFromRental(rental);
            frequentRenterPoints += computeFrequentRenterPointsIncrement(rental);
            result.append(createStatementRental(rental.getTitle(), amount));
            totalAmount += amount;
        }

        result.append(this.createStatementFooter(totalAmount, frequentRenterPoints));
        return result.toString();
    }

    private double getAmountFromRental(Rental rental) {
        double amount = 0;
        MovieType type = rental.getMovieType();
        if (type == REGULAR) {
            amount += computeAmountOfRegularRental(rental);
        } else if (type == NEW_RELEASE) {
            amount += computeAmountOfNewReleaseRental(rental);
        } else if (type == CHILDREN) {
            amount += computeAmountOfChildrenRental(rental);
        }

        return amount;
    }

    private String createStatementHeader(String name) {
        return "Rental Record for " +
                name +
                "\n";
    }

    private String createStatementRental(String title, double amount) {
        return "\t" +
                title +
                "\t" +
                amount +
                "\n";
    }

    private String createStatementFooter(double totalAmount, int frequentRenterPoints) {
        return "You owed " +
                totalAmount +
                "\nYou earned " +
                frequentRenterPoints +
                " frequent renter points\n";
    }

    private int computeFrequentRenterPointsIncrement(Rental rental) {
        if (rental.getMovieType() == NEW_RELEASE && rental.getDaysRented() > 1) {
            return 2;
        }
        return 1;
    }

    private double computeAmountOfRegularRental(Rental rental) {
        double amount = 2;
        if (rental.getDaysRented() > 2) {
            amount += (rental.getDaysRented() - 2) * 1.5;
        }
        return amount;
    }

    private double computeAmountOfNewReleaseRental(Rental rental) {
        return rental.getDaysRented() * 3;
    }

    private double computeAmountOfChildrenRental(Rental rental) {
        double amount = 1.5;
        if (rental.getDaysRented() > 3) {
            amount += (rental.getDaysRented() - 3) * 1.5;
        }
        return amount;
    }
}