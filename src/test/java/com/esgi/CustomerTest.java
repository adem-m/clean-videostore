package com.esgi;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
    @Test
    public void should_get_name_when_getter_is_used() {
        Customer customer = new Customer("Bob");
        Assert.assertEquals("Bob", customer.getName());
    }

    @Test
    public void should_create_statement() {
        Customer customer = new Customer("Tom");
        customer.addRental(new Rental(new Movie("Toy Story", MovieType.CHILDREN), 4));
        customer.addRental(new Rental(new Movie("Toy Story 2", MovieType.CHILDREN), 1));
        Assert.assertEquals(
                "Rental Record for Tom\n" +
                        "\tToy Story\t3.0\n" +
                        "\tToy Story 2\t1.5\n" +
                        "You owed 4.5\n" +
                        "You earned 2 frequent renter points\n", customer.createStatement());
    }
}
