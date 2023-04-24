package org.example.provider;

import org.example.service.CurrencyConverter;
import org.example.service.annotation.Currency;

@Currency("USD")
public class USDConvert implements CurrencyConverter {
    @Override
    public double getCurrencyConverter(double amount) {
        System.out.println("USDConvert created");
        return amount * 9.52;
    }
}
