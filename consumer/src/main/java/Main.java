import org.example.service.Service;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        printMenu();
        int choice = sc.nextInt();
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
