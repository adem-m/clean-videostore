package com.esgi;

import org.junit.Assert;
import org.junit.Test;

public class StatementTest {
    private final Statement statement = new Statement();
    private final String name = "Odessa";

    @Test
    public void Should_GenerateStatement_When_MethodIsUsed() {
        Customer customer = new Customer(this.name);
        customer.addRental(new Rental(
                new Movie("Astérix", MovieType.CHILDREN),
                6));
        customer.addRental(new Rental(
                new Movie("Pulp Fiction", MovieType.REGULAR),
                1));
        customer.addRental(new Rental(
                new Movie("OSS 117 Alerte Rouge en Afrique noire", MovieType.NEW_RELEASE),
                1));

        Assert.assertEquals(
                "Rental Record for " + this.name + "\n" +
                        "\tAstérix\t6.0\n" +
                        "\tPulp Fiction\t2.0\n" +
                        "\tOSS 117 Alerte Rouge en Afrique noire\t3.0\n" +
                        "You owed 11.0\n" +
                        "You earned 3 frequent renter points\n", this.statement.generateStatement(customer));
    }

    @Test
    public void Should_GenerateEmptyStatement_When_MethodIsUsed() {
        Customer customer = new Customer(this.name);

        Assert.assertEquals(
                "Rental Record for " + this.name + "\n" +
                        "You owed 0.0\n" +
                        "You earned 0 frequent renter points\n", this.statement.generateStatement(customer));
    }
}
