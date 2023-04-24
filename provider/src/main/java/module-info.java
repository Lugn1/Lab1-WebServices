import org.example.provider.EUROConvert;
import org.example.provider.GBPConvert;
import org.example.provider.USDConvert;
import org.example.service.CurrencyConverter;

module org.example.provider {
    requires org.example.service;
    provides CurrencyConverter with EUROConvert, GBPConvert, USDConvert;

}