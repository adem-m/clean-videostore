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
}
