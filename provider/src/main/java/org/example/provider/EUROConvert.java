package org.example.provider;

import org.example.service.CurrencyConverter;

public class EUROConvert implements CurrencyConverter {
    @Override
    public double getCurrencyConverter() {
        return 10.55;
    }
}
