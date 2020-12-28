package com.esgi;

import org.junit.Assert;
import org.junit.Test;

public class RentalTest {
    @Test
    public void should_get_days_rented_when_getter_is_used() {
        Rental rental = new Rental(new Movie("Titanic", MovieType.REGULAR), 5);
        Assert.assertEquals(5, rental.getDaysRented());
    }

    @Test
    public void should_get_movie_type_when_getter_is_used() {
        Rental rental = new Rental(new Movie("Titanic", MovieType.REGULAR), 5);
        Assert.assertEquals(MovieType.REGULAR, rental.getMovieType());
    }

    @Test
    public void should_get_movie_title_when_getter_is_used() {
        Rental rental = new Rental(new Movie("Titanic", MovieType.REGULAR), 5);
        Assert.assertEquals("Titanic", rental.getTitle());
    }
}
