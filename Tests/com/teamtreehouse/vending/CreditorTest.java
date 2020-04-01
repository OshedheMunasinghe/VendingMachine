package com.teamtreehouse.vending;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class CreditorTest {
    @Test
    public void addingFundsIncrementsAvailableFunds(){
        Creditor creditor = new Creditor();
        creditor.addFunds(25);
        creditor.addFunds(25);

        assertEquals(50, creditor.getAvailableFunds());
    }

    @Test
    public void refundingReturnsAllAvailableFunds() {
        Creditor creditor = new Creditor();
        creditor.addFunds(10);

        int refund = creditor.refund();
        assertEquals(10, refund);

    }

    @Test
    public void refundingResetsAvailableFundsToZero() {
        Creditor creditor = new Creditor();
        assertEquals(0, creditor.getAvailableFunds());
    }

}