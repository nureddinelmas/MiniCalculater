package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static double GetNumber() {
        while (true) {
            // Läs in vad användaren har skrivit
            String tal1 = sc.nextLine();

            // Om det är Marcus, returnera 42 direkt
            if (tal1.equals("MARCUS")) {
                return 42.0;
            }

            // Annars, FÖRSÖK konvertera strängen till en double
            try {
                double result = Double.parseDouble(tal1);
                return result;
            } catch (NumberFormatException e) {
                //System.out.println("Du skrev in nonsens, jag väljer ett tal åt dig istället.");
                //return 12;
                System.out.println("DEt där förstår jag inte, försök igen");
            }
        }
    }

    // This method returns temperature within 1 decimal precision
    public static double CelsiusToFahrenheit(double temp) {
        return temp * (9.0/5.0) + 32;
    }

    public static double FahrenheitToCelsius(double temp) {
        return (temp - 32) * (5.0/9.0);
    }

    // Utför en given operation (+, -, * eller /) på två givna flyttal.
    // Returnerar Double.Infinity om du försöker dela med noll.
    // Returnerar Double.NaN om operationen är ogiltig/okänd.
    public static double Calculate(double left, double right, String operation)
            throws RuntimeException {
        switch (operation) {
            case "*":
                return right * left;
            case "/":
                // TODO vad händer om vi delar med noll?
                return left / right;
            case "+":
                return left + right;
            case "-":
                return left - right;
        }
        // vad händer om operation inte är någon av dessa?
        throw new RuntimeException("Invalid operator");

        // ...
    }

    public static void main(String[] args) {
        while (true) {
            // Läs in ett kommando från användaren
            String command = sc.nextLine();

            // Operation som kräver två tal
            if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
                System.out.println("Skriv ett tal:");
                double a = GetNumber();

                System.out.println("Skriv in ett till tal:");
                double b = GetNumber();

                double result = Calculate(a, b, command);

                System.out.println(result);
            }

            // Temperaturomvandling C -> F
            else if (command.equals("C")) {
                System.out.println("Skriv en temperatur (i Celsius):");
                double c = GetNumber();
                double f = CelsiusToFahrenheit(c);
                System.out.println(f);
            }

            // Temperaturomvandling F -> C
            else if (command.equals("F")) {
                System.out.println("Skriv en temperatur (i Fahrenheit):");
                double f = GetNumber();
                double c = FahrenheitToCelsius(f);
                System.out.println(c);
            }

            else if (command.equals("quit")) {
                break;
            }

            else {
                System.out.println("Förlåt?");
            }
        }
    }
}
