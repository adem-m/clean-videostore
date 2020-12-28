package com.esgi;

import java.util.List;

import static com.esgi.MovieType.*;

public class Statement {
    final static int BIG_BONUS = 2;
    final static int REGULAR_BONUS = 1;

    double totalAmount = 0;
    int frequentRenterPoints = 0;
    StringBuilder result = new StringBuilder();

    public String getStatement(List<Rental> rentals, String name) {
        this.result.append(this.createStatementHeader(name));
        AmountComputer amountComputer = new AmountComputer();

        for (Rental rental : rentals) {
            double amount = amountComputer.compute(rental);
            this.frequentRenterPoints += computeFrequentRenterPointsIncrement(rental);
            this.result.append(createStatementRental(rental.getTitle(), amount));
            this.totalAmount += amount;
        }

        this.result.append(this.createStatementFooter(this.totalAmount, this.frequentRenterPoints));
        return this.result.toString();
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
            return BIG_BONUS;
        }
        return REGULAR_BONUS;
    }
}
