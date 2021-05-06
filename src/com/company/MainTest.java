package com.company;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/*
    - Temperatur: Jämföra >1 värde
    - Vi kan aldrig vara 100% säkra, men rimligt säkra

    - Calculate: Ett test räcker inte
    - Vad händer i "dåliga" fall?

    - GetNumber: Kan inte använda funktionen direkt som den är
    - Vi behöver simulera en användare!
        - Antingen genom att kunna byta ut Scanner-objektet
        - eller med mocking
 */

class MainTest {
    static final double DELTA = 0.001;
    @Test
    void celsiusToFahrenheit() {
        // AAA - Arrange, Act, Assert
        // Arrange
        double temp = 37;

        // Act
        double result = Main.CelsiusToFahrenheit(temp); // 98,600000004

        // Assert
        assertTrue(result != temp);
        assertEquals(98.60, result, DELTA);

        //assertEquals(98.6, Main.CelsiusToFahrenheit(37), 0.001);
    }

    @ParameterizedTest
    @CsvSource({"0,32", "-40,-40", "37,98.6"})
    void TemperatureTest(double c, double f) {
        double result = Main.CelsiusToFahrenheit(c);
        assertEquals(f, result, 0.001);
    }

    @Test
    void celsiusToFahrenheit2() {
        double temp = 0;
        double result = Main.CelsiusToFahrenheit(temp);
        assertEquals(32.0, result, DELTA);
    }

    @Test
    void fahrenheitToCelsius() {
        double temp = 98.6;
        double result = Main.FahrenheitToCelsius(temp);
        assertEquals(37.0, result, 0.001);
        //assertTrue(37.0 == result);
    }

    @Test
    void calculate() {
        // Arrange
        double left = 5, right = 7;

        // Act
        double result_plus = Main.Calculate(left, right, "+");
        double result_minus = Main.Calculate(left, right, "-");
        double result_mul = Main.Calculate(left, right, "*");
        double result_div = Main.Calculate(left, right, "/");
        double result_div2 = Main.Calculate(left, 0, "/");

        // Assert
        assertEquals(12.0, result_plus, DELTA);
        assertEquals(-2.0, result_minus, DELTA);
        assertEquals(35, result_mul, DELTA);
        assertEquals(0.714, result_div, DELTA);
        assertTrue(Double.isInfinite(result_div2));
    }

    @Test
    void calculate2() {
        assertThrows(RuntimeException.class, () -> {
            Main.Calculate(5, 7, "hej");
        });

        //double result = Main.Calculate(5, 7, "hej");
        //assertTrue(Double.isNaN(result));

        //double result2 = Main.Calculate(5, 7, "+");
        //assertFalse(Double.isNaN(result2));

        // Vad förväntar jag mig ska hända?

        // - Returnera noll?
        // - NaN
        // - Exceptions
    }

    @Test
    void GetNumberTest() {
        // Arrange
        Scanner old = Main.sc;
        Main.sc = new Scanner(new ByteArrayInputStream("12\nhej\n13\nMARCUS\n".getBytes()));

        // Act
        double result = Main.GetNumber();

        // Assert
        assertEquals(result, 12.0);

        result = Main.GetNumber();
        assertEquals(result, 13.0);

        result = Main.GetNumber();
        assertEquals(result, 42.0);

        Main.sc = old;
    }
}