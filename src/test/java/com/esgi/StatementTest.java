package com.esgi;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StatementTest {
    @Test
    public void Should_CreateStatement_When_MethodIsUsed() {
        Statement statement = new Statement();
        String name = "Alif";
        List<Rental> rentals = new ArrayList<>();
        rentals.add(new Rental(new Movie("Astérix", MovieType.CHILDREN), 6));
        rentals.add(new Rental(new Movie("Pulp Fiction", MovieType.REGULAR), 1));
        rentals.add(new Rental(new Movie("OSS 117 Alerte Rouge en Afrique noire", MovieType.NEW_RELEASE), 1));

        Assert.assertEquals(
                "Rental Record for " + name + "\n" +
                        "\tAstérix\t6.0\n" +
                        "\tPulp Fiction\t2.0\n" +
                        "\tOSS 117 Alerte Rouge en Afrique noire\t3.0\n" +
                        "You owed 11.0\n" +
                        "You earned 3 frequent renter points\n", statement.getStatement(rentals, name));
    }
}
