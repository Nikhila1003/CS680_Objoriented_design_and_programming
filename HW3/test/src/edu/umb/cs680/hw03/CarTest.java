package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {

    private String[] carToStringArray(Car car) {
        return new String[]{car.getMake(), car.getModel(), Integer.toString(car.getYear())};
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear() {
        String[] expected = new String[]{"Audi", "Q3", "2019"};
        Car actual = new Car("Audi", "Q3", 500, 2019, 40000);
        assertArrayEquals(expected, carToStringArray(actual));
    }

}
