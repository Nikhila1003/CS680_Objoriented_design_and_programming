package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PrimeGeneratorTest {

    @Test
    public void generatePrimesBetween20And45() {
        PrimeGenerator primeGenerator = new PrimeGenerator(20, 45);
        primeGenerator.generatePrimes();
        Long[] expectedPrimes = {23L, 29L, 31L, 37L, 41L, 43L};
        assertArrayEquals(expectedPrimes, primeGenerator.getPrimes().toArray());

    }

    @Test
    public void StartAndEndValuesAreSame() {
        try {
            PrimeGenerator primeGenerator = new PrimeGenerator(50, 50);
            primeGenerator.generatePrimes();
        } catch (Exception ex) {
            assertEquals("Wrong input values: from=" + 50 + " to=" + 50, ex.getMessage());
        }
    }

    @Test
    public void StartValueIsANegativeNumber() {
        try {
            PrimeGenerator primeGenerator = new PrimeGenerator(-50, 50);
            primeGenerator.generatePrimes();
        } catch (Exception ex) {
            assertEquals("Wrong input values: from=" + -50 + " to=" + 50, ex.getMessage());
        }
    }

    @Test
    public void EndValueIsANegativeNumber() {
        try {
            PrimeGenerator primeGenerator = new PrimeGenerator(50, -50);
            primeGenerator.generatePrimes();
        } catch (Exception ex) {
            assertEquals("Wrong input values: from=" + 50 + " to=" + -50, ex.getMessage());
        }
    }

    @Test
    public void StartValueIsGreaterThanEndValue() {
        try {
            PrimeGenerator primeGenerator = new PrimeGenerator(50, 30);
            primeGenerator.generatePrimes();
        } catch (Exception ex) {
            assertEquals("Wrong input values: from=" + 50 + " to=" + 30, ex.getMessage());
        }
    }

}
