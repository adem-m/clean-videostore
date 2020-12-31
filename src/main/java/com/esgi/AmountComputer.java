package com.esgi;

import static com.esgi.MovieType.*;

public class AmountComputer {
    static final double SHORT_REGULAR_RENTAL_LIMIT = 2;
    static final double BASE_REGULAR_RENTAL_AMOUNT = 2;

    static final double SHORT_CHILDREN_RENTAL_LIMIT = 3;
    static final double BASE_CHILDREN_RENTAL_AMOUNT = 1.5;

    public double compute(Rental rental) {
        MovieType type = rental.getMovieType();
        if (type == CHILDREN) {
            return computeAmountOfChildrenRental(rental);
        } else if (type == NEW_RELEASE) {
            return computeAmountOfNewReleaseRental(rental);
        } else {
            // this is for "regular or another new type" movie
            return computeAmountOfRegularRental(rental);
        }
    }

    private double computeAmountOfRegularRental(Rental rental) {
        if (rental.getDaysRented() > SHORT_REGULAR_RENTAL_LIMIT) {
            return BASE_REGULAR_RENTAL_AMOUNT + (rental.getDaysRented() - 2) * 1.5;
        }
        return BASE_REGULAR_RENTAL_AMOUNT;
    }

    private double computeAmountOfNewReleaseRental(Rental rental) {
        return rental.getDaysRented() * 3;
    }

    private double computeAmountOfChildrenRental(Rental rental) {
        if (rental.getDaysRented() > SHORT_CHILDREN_RENTAL_LIMIT) {
            return BASE_CHILDREN_RENTAL_AMOUNT + (rental.getDaysRented() - 3) * 1.5;
        }
        return BASE_CHILDREN_RENTAL_AMOUNT;
    }
}
