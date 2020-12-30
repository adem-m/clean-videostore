package com.esgi;

import java.util.List;

import static com.esgi.MovieType.*;

public class Statement {
    private final static int BIG_BONUS = 2;
    private final static int REGULAR_BONUS = 1;

    public String getStatement(List<Rental> rentals, String name) {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder();
        AmountComputer amountComputer = new AmountComputer();

        result.append(this.createStatementHeader(name));

        for (Rental rental : rentals) {
            double amount = amountComputer.compute(rental);
            frequentRenterPoints += computeFrequentRenterPointsIncrement(rental);
            result.append(createStatementRental(rental.getTitle(), amount));
            totalAmount += amount;
        }

        result.append(this.createStatementFooter(totalAmount, frequentRenterPoints));
        return result.toString();
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
