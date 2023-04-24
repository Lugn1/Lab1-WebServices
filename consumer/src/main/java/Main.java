import org.example.service.CurrencyConverter;

import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        printMenu();
        loadCurrencyConverters();




    }

    private static void loadCurrencyConverters() {
        ServiceLoader<CurrencyConverter> currencyConverters = ServiceLoader.load(CurrencyConverter.class);

        for (var converters : currencyConverters) {
            System.out.println(converters.getCurrencyConverter());
        }
    }

    private static void printMenu() {

        System.out.println("Välkommen till valutaomvandlaren!");
        System.out.println("1. Euro (EUR)");
        System.out.println("2. US - Dollar (USD)");
        System.out.println("3. British Pound (GBP)");
        System.out.println("0. Avsluta");
        System.out.println("\nVälj vilken valuta du vill omvandla till: ");

    }
}
