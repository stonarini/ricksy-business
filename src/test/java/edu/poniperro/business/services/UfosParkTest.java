package edu.poniperro.business.services;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.poniperro.business.payment.CreditCard;

public class UfosParkTest {
	UfosPark ufosPark;
	CreditCard creditCard;

	@Before
	public void setup() {
		this.creditCard = new CreditCard("Name", "12345ABC");
		this.ufosPark = new UfosPark();
		String[] ufos = { "unx", "dox" };
		for (String ufo : ufos) {
			ufosPark.add(ufo);
		}
	}

	@Test
	public void dispatchTest() {
		assertNull(ufosPark.getUfoOf(creditCard.number()));
		ufosPark.dispatch(creditCard);
		String ufoOf = ufosPark.getUfoOf(creditCard.number());
		assertTrue("unx" == ufoOf || "dox" == ufoOf);

	}

	@Test
	public void dispatchFlotaOcupadaTest() {
		ufosPark.dispatch(new CreditCard("OtherName", "Number"));
		ufosPark.dispatch(new CreditCard("NewName", "OtherNumber"));
		ufosPark.dispatch(creditCard);
		assertNull(ufosPark.getUfoOf(creditCard.number()));
	}

	@Test
	public void emptyCreditCardTest() {
		creditCard.pay(3000);
		ufosPark.dispatch(creditCard);
		assertNull(ufosPark.getUfoOf(creditCard.number()));
	}

}
