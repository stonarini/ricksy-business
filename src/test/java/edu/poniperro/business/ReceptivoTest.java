package edu.poniperro.business;

import org.junit.Before;
import org.junit.Test;

public class ReceptivoTest {
	Receptivo receptivo;

	@Before
	public void setup() {
		receptivo = new Receptivo();
	}

	@Test
	public void addServiceTest() {
		receptivo.registra(new UfosPark());
		receptivo.registra(new CrystalExpender());
	}

	@Test
	public void dispatchService() {
		receptivo.registra(new UfosPark());
		receptivo.registra(new CrystalExpender());
		receptivo.dispatch(new CreditCard("Name", "1234ABC"));
	}
}
