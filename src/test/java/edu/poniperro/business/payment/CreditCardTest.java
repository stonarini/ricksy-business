package edu.poniperro.business.payment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CreditCardTest {
    CreditCard creditCard;

    @Before
    public void setup() {
        this.creditCard = new CreditCard("Name", "CardNumber");
    }

    @Test
    public void creditTest() {
        assertEquals(3000, creditCard.credit(), 0);
    }

    @Test
    public void cardOwnerTest() {
        assertEquals("Name", creditCard.cardOwner());
    }

    @Test
    public void numberTest() {
        assertEquals("CardNumber", creditCard.number());
    }

    @Test
    public void payTest() {
        assertTrue(creditCard.pay(2500));
        assertEquals(500, creditCard.credit(), 0);
    }

    @Test
    public void payWithoutCreditTest() {
        assertFalse(creditCard.pay(3500));
        assertEquals(3000, creditCard.credit(), 0);
    }
}
