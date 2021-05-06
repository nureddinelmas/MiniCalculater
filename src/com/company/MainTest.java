package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/*
 -temperatur Jämföra >1 värde
 - Vi kan aldrig vara %100 säkra, men rimlig säkra

 */
class MainTest {
    static final double Delta = 0.001;
    @Test
    void addNumbers() {
        //int x = -2100000000;
        float a = 0.1f;
        float b = 0.2f;
        float c = a + b;  // 0.30000000000004

        assertEquals(0.3f, c);
    }

    @Test
    void celsiusToFahrenheit() {
        // AAA - Arrange, Act, Assert
        // Arrange
        double temp = 37;

        // Act
        double result = Main.CelsiusToFahrenheit(temp); // 98,600000004

        // Assert
        assertTrue(result != temp);
        assertEquals(98.60, result, Delta);

        //assertEquals(98.6, Main.CelsiusToFahrenheit(37), 0.001);
    }

    @Test
    void fahrenheitToCelsius() {
    double temp = 98.6;
    double result = Main.FahrenheitToCelsius(temp);
    assertEquals(37, result,Delta);
    assertTrue(37 == result);
    }

    @Test
    void calculate() {
// Arrange
        double left = 5, right = 7;
        String op = "+";

        //  Act
        double result = Main.Calculate(left, right,op);

        // Assert
        assertEquals(12,result,Delta);
    }
}