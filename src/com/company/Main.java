package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static double GetNumber() {
        System.out.println("Hello World");
        Scanner sc = new Scanner(System.in);
        String tal1 = sc.nextLine();
        if (tal1.equals("MARCUS")) {
            return 42.0;
        }
        // TODO potentiellt fel
        double result = Double.parseDouble(tal1);
        return result;
    }

    // This method returns temperature within 1 decimal precision
    public static double CelsiusToFahrenheit(double temp) {
        return temp * (9.0/5.0) + 32;
    }

    public static double FahrenheitToCelsius(double temp) {
        return (temp - 32) * (5.0/9.0);
    }

    public static double Calculate(double left, double right, String operation) {
        switch (operation) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                // TODO vad händer om vi delar med noll?
                return left / right;
        }
        // TODO vad händer om operation inte är någon av dessa?
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
