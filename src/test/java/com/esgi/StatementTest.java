package com.esgi;

import org.junit.Assert;
import org.junit.Test;

public class StatementTest {
    @Test
    public void Should_GenerateStatement_When_MethodIsUsed() {
        String name = "Odessa";
        Customer customer = new Customer(name);
        customer.addRental(new Rental(
                new Movie("Astérix", MovieType.CHILDREN),
                6));
        customer.addRental(new Rental(
                new Movie("Pulp Fiction", MovieType.REGULAR),
                1));
        customer.addRental(new Rental(
                new Movie("OSS 117 Alerte Rouge en Afrique noire", MovieType.NEW_RELEASE),
                1));

        Statement statement = new Statement();

        Assert.assertEquals(
                "Rental Record for " + name + "\n" +
                        "\tAstérix\t6.0\n" +
                        "\tPulp Fiction\t2.0\n" +
                        "\tOSS 117 Alerte Rouge en Afrique noire\t3.0\n" +
                        "You owed 11.0\n" +
                        "You earned 3 frequent renter points\n", statement.generateStatement(customer));
    }
}
