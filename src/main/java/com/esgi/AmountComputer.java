package com.esgi;

import static com.esgi.MovieType.*;

public class AmountComputer {
    public double compute(Rental rental) {
        double amount = 0;
        MovieType type = rental.getMovieType();
        if (type == CHILDREN) {
            amount += computeAmountOfChildrenRental(rental);
        } else if (type == NEW_RELEASE) {
            amount += computeAmountOfNewReleaseRental(rental);
        } else {
            // this is for "regular or another new type" movie
            amount += computeAmountOfRegularRental(rental);
        }
        return amount;
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
