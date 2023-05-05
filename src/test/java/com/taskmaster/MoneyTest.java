package com.taskmaster;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void convertsMoneyCorrectlyToDifferentCurrency() {
        Money money = new Money(100, Currency.USD);
        Money convertedMoney = Money.convertMoneyToCurrency(money, Currency.GHC);

        Assertions.assertEquals(new Money(1160.0, Currency.GHC), convertedMoney);
    }

    @Test
    void multipliesMoneyCorrectly() {
        Money money = new Money(100, Currency.USD);
        Assertions.assertEquals(new Money(1000,money.getCurrency()), Money.product(money,10));
    }

    @Test
    void dividesMoneyByScalarCorrectly() {
        Money money = new Money(100, Currency.USD);
        Assertions.assertEquals(new Money(10,money.getCurrency()), Money.quotient(money,10));
    }

    @Test
    void dividesMoneyByMoneyCorrectlyForSameCurrency() {
        Money money = new Money(100, Currency.USD);
        Money money1 = new Money(20, Currency.USD);
        Assertions.assertEquals(5.0, Money.quotient(money, money1));
    }

    @Test
    void dividesMoneyByMoneyCorrectlyForDifferentCurrency() {
        Money money = new Money(13400, Currency.JPY);
        Money money1 = new Money(20, Currency.USD);
        Assertions.assertEquals(5.0, Money.quotient(money, money1));
    }

    @Test
    void sumsMoneyCorrectlyForSameCurrency() {
        Money money = new Money(100, Currency.USD);
        Money money1 = new Money(20, Currency.USD);

        Assertions.assertEquals(new Money(120.0, money.getCurrency()), Money.sum(money, money1));
    }

    @Test
    void sumsMoneyCorrectlyForDifferentCurrency() {
        Money money = new Money(13400, Currency.JPY);
        Money money1 = new Money(100, Currency.USD);

        Assertions.assertEquals(new Money(26800, money.getCurrency()), Money.sum(money, money1));
    }

    @Test
    void subtractsMoneyCorrectlyForSameCurrency() {
        Money money = new Money(100, Currency.USD);
        Money money1 = new Money(20, Currency.USD);

        Assertions.assertEquals(new Money(80.0, money.getCurrency()), Money.difference(money, money1));
    }

    @Test
    void subtractsMoneyCorrectlyForDifferentCurrency() {
        Money money = new Money(26800, Currency.JPY);
        Money money1 = new Money(100, Currency.USD);

        Assertions.assertEquals(new Money(13400, money.getCurrency()), Money.difference(money, money1));
    }



}