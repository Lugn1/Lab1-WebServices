package org.example.provider;

import org.example.service.CurrencyConverter;

public class GBPConvert implements CurrencyConverter {
    @Override
    public double getCurrencyConverter() {
        return 11.63;
    }
}
