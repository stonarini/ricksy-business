package edu.poniperro.business.services;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.poniperro.business.payment.CreditCard;

public class CrystalExpenderTest {
	CrystalExpender crystalExpender;
	CreditCard creditCard;

	@Before
	public void setup() {
		this.creditCard = new CreditCard("Name", "12345ABC");
		this.crystalExpender = new CrystalExpender(2, 5);
	}

	@Test
	public void dispatchTest() {
		assertEquals(2, crystalExpender.stock());
		crystalExpender.dispatch(creditCard);
		assertEquals(1, crystalExpender.stock());
	}

	@Test
	public void dispatchStockEmptyTest() {
		assertEquals(2, crystalExpender.stock());
		crystalExpender.dispatch(creditCard);
		assertEquals(1, crystalExpender.stock());
		crystalExpender.dispatch(creditCard);
		crystalExpender.dispatch(creditCard);
		crystalExpender.dispatch(creditCard);
		assertEquals(0, crystalExpender.stock());
	}

}
