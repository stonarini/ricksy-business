package edu.poniperro.business.services;

import edu.poniperro.business.payment.CreditCard;

public class CrystalExpender implements GuestDispatcher {
	private int stock;
	private double itemCost;

	public CrystalExpender(int stock, double itemCost) {
		this.stock = stock;
		this.itemCost = itemCost;
	}

}
