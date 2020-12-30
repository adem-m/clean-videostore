package com.esgi;

import org.junit.Assert;
import org.junit.Test;

public class AmountComputerTest {
    private final Movie regular = new Movie("James Bond", MovieType.REGULAR);
    private final Movie newRelease = new Movie("Tenet", MovieType.NEW_RELEASE);
    private final Movie children = new Movie("Zootopia", MovieType.CHILDREN);

    @Test
    public void Should_ComputeAmount_When_LongRentRegularMovie() {
        Rental rental = new Rental(this.regular, 5);
        Assert.assertEquals(6.5, new AmountComputer().compute(rental), 0.01);
    }

    @Test
    public void Should_ComputeAmount_When_ShortRentRegularMovie() {
        Rental rental = new Rental(this.regular, 1);
        Assert.assertEquals(2.0, new AmountComputer().compute(rental), 0.01);
    }

    @Test
    public void Should_ComputeAmount_When_NewReleaseMovie() {
        Rental rental = new Rental(this.newRelease, 3);
        Assert.assertEquals(9.0, new AmountComputer().compute(rental), 0.01);
    }

    @Test
    public void Should_ComputeAmount_When_LongRentChildrenMovie() {
        Rental rental = new Rental(this.children, 8);
        Assert.assertEquals(9.0, new AmountComputer().compute(rental), 0.01);
    }

    @Test
    public void Should_ComputeAmount_When_ShortRentChildrenMovie() {
        Rental rental = new Rental(this.children, 2);
        Assert.assertEquals(1.5, new AmountComputer().compute(rental), 0.01);
    }
}
