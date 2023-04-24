package org.example.provider;

import org.example.service.CurrencyConverter;
import org.example.service.annotation.Currency;

@Currency("EURO")
public class EUROConvert implements CurrencyConverter {

    @Override
    public double getCurrencyConverter(double amount) {
        System.out.println("Svenska kronor till Euro:");
        return amount * 0.088;
    }
}
