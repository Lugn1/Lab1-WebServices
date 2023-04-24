import org.example.provider.EUROConvert;
import org.example.provider.GBPConvert;
import org.example.provider.USDConvert;
import org.example.service.CurrencyConverter;

module org.example.provider {
    requires org.example.service;
    exports org.example.provider;
    provides CurrencyConverter with GBPConvert, USDConvert, EUROConvert;


}