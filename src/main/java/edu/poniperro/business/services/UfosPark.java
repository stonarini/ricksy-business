package edu.poniperro.business.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import edu.poniperro.business.payment.CreditCard;

public class UfosPark implements GuestDispatcher {
	private double fee = 500d;
	private final Map<String, String> flota = new HashMap<String, String>();

	public UfosPark() {

	}

	public void add(String ufo) {
		this.flota.put(ufo, null);
	}

	@Override
	public void dispatch(CreditCard creditCard) {
		Optional<String> ufo = getFreeUfo();

		if (!flota.containsValue(creditCard.number()) && ufo.isPresent()) {
			if (creditCard.pay(fee)) {
				flota.put(ufo.get(), creditCard.number());
			}
		}

	}

	private Optional<String> getFreeUfo() {
		return this.flota.entrySet().stream()
				.filter(u -> u.getValue() == null)
				.map(u -> u.getKey())
				.findAny();
	}

	public String getUfoOf(String cardNumber) {
		if (flota.containsValue(cardNumber)) {
			return flota.entrySet().stream()
					.filter(u -> u.getValue() == cardNumber)
					.map(u -> u.getKey())
					.findFirst()
					.get();
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		return flota.keySet().toString();
	}
}
