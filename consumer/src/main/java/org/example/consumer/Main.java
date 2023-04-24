package org.example.consumer;

import org.example.service.CurrencyConverter;
import org.example.service.annotation.Currency;

import java.util.List;
import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {

    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        boolean flag = true;
        while (flag) {
            printMenu();

            switch (sc.nextLine()) {
                case "1" -> {
                    System.out.println("Du valde Euro (EUR). Ange belopp i kronor: ");
                    while (true) {
                        try {
                            convertToEuro(Double.parseDouble(sc.nextLine()));
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Felaktig inmatning, försök igen: ");
                        }
                    }
                    flag = askUserForAnotherConversion();
                }
                case "2" -> {
                    while (true) {
                        try {
                            System.out.println("Du valde US Dollar (USD). Ange belopp i kronor: ");
                            convertToUSD(Double.parseDouble(sc.nextLine()));
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Felaktig inmatning, försök igen: ");
                        }
                    }
                    flag = askUserForAnotherConversion();
                }
                case "3" -> {
                    while (true) {
                        try {
                            System.out.println("Du valde British Pound (GBP). Ange belopp i kronor: ");
                            convertToGBP(Double.parseDouble(sc.nextLine()));
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Felaktig inmatning, försök igen: ");
                        }
                    }
                    flag = askUserForAnotherConversion();
                }
                case "0" -> {
                    System.out.println("Avslutar...");
                    System.exit(0);
                }
                default -> System.out.println("Felaktig inmatning, försök igen!");
            }
        }
    }


    private static void convertToEuro(double amount) {
        for (var converters : getCurrencyConverter("EURO")) {
            System.out.println(amount + " kr ger dig " + converters.getCurrencyConverter(amount) + " EUR");
        }
    }

    private static void convertToUSD(double amount) {
        for (var converters : getCurrencyConverter("USD")) {
            System.out.println(amount + " kr ger dig " + converters.getCurrencyConverter(amount) + " USD");
        }
    }

    private static void convertToGBP(double amount) {
        for (var converters : getCurrencyConverter("GBP")) {
            System.out.println(amount + " kr ger dig " + converters.getCurrencyConverter(amount) + " GBP");
        }
    }

    private static List<CurrencyConverter> getCurrencyConverter(String chosenCurrency) {

        ServiceLoader<CurrencyConverter> currencyConverters = ServiceLoader.load(CurrencyConverter.class);

        return currencyConverters.stream()
                .filter(c -> c.type().isAnnotationPresent(Currency.class) &&
                        c.type().getAnnotation(Currency.class).value().equals(chosenCurrency))
                .map(ServiceLoader.Provider::get)
                .toList();
    }


    private static boolean askUserForAnotherConversion() {
        System.out.println("Vill du göra en ny omvandling? (J/N)");
        if (sc.nextLine().equalsIgnoreCase("N")) {
            System.out.println("Avslutar...");
            return false;
        }
        return true;
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
