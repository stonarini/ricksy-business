package edu.poniperro.business;

import java.util.LinkedList;
import java.util.List;

import edu.poniperro.business.payment.CreditCard;
import edu.poniperro.business.services.GuestDispatcher;

public class Receptivo {
	private final List<GuestDispatcher> observers = new LinkedList<GuestDispatcher>();

	public Receptivo() {
	};

	public void registra(GuestDispatcher guestDispatcher) {
		this.observers.add(guestDispatcher);
	}

	public void dispatch(CreditCard creditCard) {
		this.observers.stream().forEach(g -> g.dispatch(creditCard));
	}
}
