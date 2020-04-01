package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class BinTest {

    private Bin bin;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        bin = new Bin(10);
    }

    @Test
    public void restockingWithDifferentItemsIsNotAllowed() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Cannot restock Cheetos with Doritos");
        bin.restock("Cheetos", 1, 100, 50);
        bin.restock("Doritos", 1, 100, 50);
    }

    @Test
    public void whenEmptyPriceIsZero() {
        //för att methoden getItemName returnerar null så det måste säga noll just pricet
        assertEquals(0, bin.getItemPrice());
    }

    @Test
    public void whenEmptyNameIsNull() {
        //den kollar om det är inte null så ska den returnera false, men denna ger true för att den har redan kodat null i getItemName
        assertNull(bin.getItemName());
    }

    @Test
    public void overStockingNotAllowed() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("There are only 10 spots left");
        bin.restock("fritos", 2600, 100, 50);
    }
}