package com.esgi;

public class Rental {
    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return this.daysRented;
    }

    public MovieType getMovieType() {
        return this.movie.getMovieType();
    }

    public String getTitle() {
        return this.movie.getTitle();
    }
}
