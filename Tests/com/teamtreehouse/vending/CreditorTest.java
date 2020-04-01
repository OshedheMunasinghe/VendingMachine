package com.teamtreehouse.vending;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class CreditorTest {
    //Becuase each method has created object it is very annoying so we create setUp BeforeEach and create Object
    // "Before testing creating object.."
    Creditor creditor;

    @BeforeEach
    void setUp() {
        creditor = new Creditor();
    }

    @Test
    public void addingFundsIncrementsAvailableFunds() {
        creditor.addFunds(25);
        creditor.addFunds(25);

        assertEquals(50, creditor.getAvailableFunds());
    }

    @Test
    public void refundingReturnsAllAvailableFunds() {
        creditor.addFunds(10);

        int refund = creditor.refund();
        assertEquals(10, refund);

    }

    @Test
    public void refundingResetsAvailableFundsToZero() {
        assertEquals(0, creditor.getAvailableFunds());
    }

    @Test
    public void creditorTest() throws NotEnoughFundsException {
        creditor.addFunds(25);
        creditor.addFunds(25);
        creditor.deduct(300);
    }
}