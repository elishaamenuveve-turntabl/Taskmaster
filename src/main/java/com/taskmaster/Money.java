package com.taskmaster;

import java.util.Objects;

public class Money {
    private final double quantity;
    private final Currency currency;

    public Money(double quantity, Currency currency) {
        //TODO: handle negative money
        this.quantity = Math.round(quantity);
        this.currency = currency;
    }

    public static Money difference (Money money1, Money money2) {
        Money money2InCurrency1 = Money.convertMoneyToCurrency(money2, money1.currency);
        return new Money(Math.abs(money1.quantity - money2InCurrency1.quantity), money1.currency);

    }
    public static Money sum (Money money1, Money money2) {
        Money money2InCurrency1 = Money.convertMoneyToCurrency(money2, money1.currency);
        return new Money(money1.quantity + money2InCurrency1.quantity, money1.currency);
    }
    public static Money product (Money money, double number) {
        return new Money(money.quantity * number ,money.currency);
    }

    public static double quotient (Money dividend, Money divisor) {
        Money money2InCurrency1 = Money.convertMoneyToCurrency(divisor, dividend.currency);
        return Math.round(dividend.quantity/ money2InCurrency1.quantity);
    }

    public static Money quotient (Money money, double number) {
        return new Money(money.quantity/number, money.currency);
    }

    public static Money convertMoneyToCurrency(Money money, Currency currency){
        double newQuantity = Currency.getExchangeRate(money.getCurrency(), currency) * money.getQuantity();
        return new Money(newQuantity, currency);
    }


    public double getQuantity() {
        return quantity;
    }

    public Currency getCurrency() {
        return currency;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Double.compare(money.quantity, quantity) == 0 && currency == money.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, currency);
    }

    @Override
    public String toString() {
        return currency.getName() + " "  + String.format("%.2f",quantity) ;
    }
}
