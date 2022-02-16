package edu.poniperro.business.payment;

public class CreditCard {
    private final String owner;
    private final String number;
    private double credit;
    private final String SYMBOL;

    public CreditCard(String owner, String number) {
        this.owner = owner;
        this.number = number;
        this.credit = 3000;
        this.SYMBOL = "EZI";
    }

    public boolean pay(double value) {
        if (credit() - value >= 0) {
            this.credit -= value;
            return true;
        } else {
            return false;
        }
    }

    public String number() {
        return this.number;
    }

    public String cardOwner() {
        return this.owner;
    }

    public double credit() {
        return this.credit;
    }
}
