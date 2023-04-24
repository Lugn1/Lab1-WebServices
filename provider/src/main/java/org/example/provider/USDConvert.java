package org.example.provider;

import org.example.service.CurrencyConverter;

public class USDConvert implements CurrencyConverter {
    @Override
    public double getCurrencyConverter() {
        return 9.52;
    }
}
