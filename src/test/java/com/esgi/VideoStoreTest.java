package com.esgi;

import junit.framework.TestCase;

import static com.esgi.MovieType.*;

public class VideoStoreTest extends TestCase {
    public VideoStoreTest(String name) {
        super(name);
    }

    protected void setUp() {
        customer = new Customer("Fred");
    }

    public void testSingleNewReleaseStatement() {
        customer.addRental(new Rental(new Movie("The Cell", NEW_RELEASE), 3));
        assertEquals("Rental Record for Fred\n\tThe Cell\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n", customer.createStatement());
    }

    public void testDualNewReleaseStatement() {
        customer.addRental(new Rental(new Movie("The Cell", NEW_RELEASE), 3));
        customer.addRental(new Rental(new Movie("The Tigger Movie", NEW_RELEASE), 3));
        assertEquals("Rental Record for Fred\n\tThe Cell\t9.0\n\tThe Tigger Movie\t9.0\nYou owed 18.0\nYou earned 4 frequent renter points\n", customer.createStatement());
    }

    public void testSingleChildrensStatement() {
        customer.addRental(new Rental(new Movie("The Tigger Movie", CHILDREN), 3));
        assertEquals("Rental Record for Fred\n\tThe Tigger Movie\t1.5\nYou owed 1.5\nYou earned 1 frequent renter points\n", customer.createStatement());
    }

    public void testMultipleRegularStatement() {
        customer.addRental(new Rental(new Movie("Plan 9 from Outer Space", REGULAR), 1));
        customer.addRental(new Rental(new Movie("8 1/2", REGULAR), 2));
        customer.addRental(new Rental(new Movie("Eraserhead", REGULAR), 3));

        assertEquals("Rental Record for Fred\n\tPlan 9 from Outer Space\t2.0\n\t8 1/2\t2.0\n\tEraserhead\t3.5\nYou owed 7.5\nYou earned 3 frequent renter points\n", customer.createStatement());
    }

    private Customer customer;
}