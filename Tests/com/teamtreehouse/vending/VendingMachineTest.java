package com.teamtreehouse.vending;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineTest {


    private VendingMachine machine;

    //this is call inline class
    public class NotifierSub implements Notifier {

        @Override
        public void onSale(Item item) {
            return; //we don't want to do anything
        }
    }//end NotifierSub

    @Before
    public void setUp() throws Exception {
        //skapar object Vendinmachine där den har 10 rader och 10 kolumn och max fack 10 sty
        //Vi lägger in godis Twinkies fack A1 10 sty, 30kr/stk , netto pris 75
        Notifier notifier = new NotifierSub();
        machine = new VendingMachine(notifier, 10, 10, 10);
        machine.restock("A1", "Twinkies", 10, 30, 75);
    }

    @Test
    public void vendinWhenStockedReturnsItem() throws Exception {
        // Du betalar 75 och knappade in fack A1 och kollar att du plockar rätt godis som heter Twinkies
        machine.addMoney(75);
        Item item = machine.vend("A1");
        assertEquals("Twinkies", item.getName());
    }

    @Test
    public void successSalesTotal() throws Exception {
        //Du kollar att du har betalat för 75 i A1 just godis
        machine.addMoney(75);
        Item item = machine.vend("A1");
        assertEquals("Twinkies", item.getName());
        assertEquals(75,machine.getRunningSalesTotal());
    }
}