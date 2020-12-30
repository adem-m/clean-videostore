package com.esgi;

import org.junit.Assert;
import org.junit.Test;

public class MovieTest {
    private final Movie regular = new Movie("Titanic", MovieType.REGULAR);

    @Test
    public void Should_GetMovieTitle_When_GetterIsUsed() {
        Assert.assertEquals("Titanic", this.regular.getTitle());
    }

    @Test
    public void Should_GetMovieType_When_GetterIsUsed() {
        Assert.assertEquals(MovieType.REGULAR, this.regular.getMovieType());
    }
}
