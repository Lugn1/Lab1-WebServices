package org.example.provider;

import org.example.service.CurrencyConverter;
import org.example.service.annotation.Currency;

@Currency("GBP")
public class GBPConvert implements CurrencyConverter {
    @Override
    public double getCurrencyConverter(double amount) {
        System.out.println("Svenska kronor till Brittiska pund:");
        return amount * 0.078;
    }
}
