package edu.poniperro.business.payment;

public class CreditCard {
    private final String owner;
    private final String number;
    private final double credit;
    private final String SYMBOL;

    CreditCard(String owner, String number) {
        this.owner = owner;
        this.number = number;
        this.credit = 3000;
        this.SYMBOL = "EZI";
    }

}
