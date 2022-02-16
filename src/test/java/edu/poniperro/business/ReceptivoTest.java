package edu.poniperro.business;

import org.junit.Before;
import org.junit.Test;

import edu.poniperro.business.payment.CreditCard;
import edu.poniperro.business.services.CrystalExpender;
import edu.poniperro.business.services.UfosPark;

public class ReceptivoTest {
	Receptivo receptivo;

	@Before
	public void setup() {
		receptivo = new Receptivo();
	}

	@Test
	public void addServiceTest() {
		receptivo.registra(new UfosPark());
		receptivo.registra(new CrystalExpender(1, 1));
	}

	@Test
	public void dispatchService() {
		receptivo.registra(new UfosPark());
		receptivo.registra(new CrystalExpender(1, 4));
		receptivo.dispatch(new CreditCard("Name", "1234ABC"));
	}
}
