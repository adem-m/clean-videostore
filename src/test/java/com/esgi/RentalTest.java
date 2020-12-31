package com.esgi;

import org.junit.Assert;
import org.junit.Test;

public class RentalTest {
    private final Rental rental = new Rental(
            new Movie("Titanic", MovieType.REGULAR),
            5);

    @Test
    public void Should_GetDaysRented_When_GetterIsUsed() {
        Assert.assertEquals(5, this.rental.getDaysRented());
    }

    @Test
    public void Should_GetMovieType_When_GetterIsUsed() {
        Assert.assertEquals(MovieType.REGULAR, this.rental.getMovieType());
    }

    @Test
    public void Should_GetMovieTitle_When_GetterIsUsed() {
        Assert.assertEquals("Titanic", this.rental.getTitle());
    }
}
