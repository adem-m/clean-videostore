package com.esgi;

import java.util.List;

import static com.esgi.MovieType.*;

public class Statement {
    private final static int BIG_BONUS = 2;
    private final static int REGULAR_BONUS = 1;

    public String generateStatement(Customer customer) {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder();
        AmountComputer amountComputer = new AmountComputer();

        result.append(this.generateStatementHeader(customer.getName()));

        for (Rental rental : customer.getRentals()) {
            double amount = amountComputer.compute(rental);
            frequentRenterPoints += computeFrequentRenterPointsIncrement(rental);
            result.append(generateStatementRental(rental.getTitle(), amount));
            totalAmount += amount;
        }

        result.append(this.generateStatementFooter(totalAmount, frequentRenterPoints));
        return result.toString();
    }

    private String generateStatementHeader(String name) {
        return "Rental Record for " +
                name +
                "\n";
    }

    private String generateStatementRental(String title, double amount) {
        return "\t" +
                title +
                "\t" +
                amount +
                "\n";
    }

    private String generateStatementFooter(double totalAmount, int frequentRenterPoints) {
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
