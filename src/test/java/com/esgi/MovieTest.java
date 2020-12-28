package com.esgi;

import org.junit.Assert;
import org.junit.Test;

public class MovieTest {
    @Test
    public void should_get_movie_title_when_getter_is_used() {
        Movie movie = new Movie("Titanic", MovieType.REGULAR);
        Assert.assertEquals("Titanic", movie.getTitle());
    }

    @Test
    public void should_get_movie_type_when_getter_is_used() {
        Movie movie = new Movie("Titanic", MovieType.REGULAR);
        Assert.assertEquals(MovieType.REGULAR, movie.getMovieType());
    }
}
