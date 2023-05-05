package com.taskmaster;

public enum Currency {
    GHC(11.60, "GHC"),
    GBP(0.79, "GBP"),
    USD(1, "USD"),
    JPY(134, "JPY"),
    CAD(1.35, "CAD");

    private static double basePrice = 1;

    private final double value;
    private String name;
    Currency(double value, String name) {
        this.value = value;
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static double getExchangeRate(Currency currency1, Currency currency2) {
        return  currency2.value / currency1.value;
    }

}
