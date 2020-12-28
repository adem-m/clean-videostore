package com.esgi;

import org.junit.Assert;
import org.junit.Test;

public class AmountComputerTest {
    @Test
    public void should_compute_long_rent_regular_movie_amount() {
        Rental rental = new Rental(new Movie("James Bond", MovieType.REGULAR), 5);
        Assert.assertEquals(6.5, new AmountComputer().compute(rental), 0.01);
    }

    @Test
    public void should_compute_short_rent_regular_movie_amount() {
        Rental rental = new Rental(new Movie("James Bond", MovieType.REGULAR), 1);
        Assert.assertEquals(2.0, new AmountComputer().compute(rental), 0.01);
    }
}
