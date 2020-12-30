package com.esgi;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
    @Test
    public void Should_GetName_When_GetterIsUsed() {
        String name = "Bob";
        Customer customer = new Customer(name);
        Assert.assertEquals(name, customer.getName());
    }

    @Test
    public void Should_CreateStatement_When_MethodIsUsed() {
        Customer customer = new Customer("Tom");
        customer.addRental(new Rental(new Movie("Toy Story", MovieType.CHILDREN), 4));
        customer.addRental(new Rental(new Movie("Toy Story 2", MovieType.CHILDREN), 1));
        Assert.assertEquals(
                "Rental Record for " + customer.getName() + "\n" +
                        "\tToy Story\t3.0\n" +
                        "\tToy Story 2\t1.5\n" +
                        "You owed 4.5\n" +
                        "You earned 2 frequent renter points\n", customer.createStatement());
    }
}
