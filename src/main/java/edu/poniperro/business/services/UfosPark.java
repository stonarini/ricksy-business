package edu.poniperro.business.services;

import java.util.HashMap;
import java.util.Map;

import edu.poniperro.business.payment.CreditCard;

public class UfosPark implements GuestDispatcher {
	private double fee = 500d;
	private final Map<String, String> flota = new HashMap<String, String>();

	public UfosPark() {

	}

	@Override
	public void dispatch(CreditCard creditCard) {

	}
}
