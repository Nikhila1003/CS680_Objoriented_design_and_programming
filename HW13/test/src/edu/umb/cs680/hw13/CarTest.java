package edu.umb.cs680.hw13;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CarTest {

    @Test
    public void priceAscendingOrderSortTest() {
        Car car1 = new Car("Tesla", "X", 100, 2012, 1000);
        Car car2 = new Car("Tesla", "Y", 20, 2016, 2000);
        Car car3 = new Car("Tesla", "X3", 50, 2020, 5000);
        ArrayList<Car> actual = new ArrayList<>();
        Collections.addAll(actual, car1, car2, car3);
        ArrayList<Car> expected = new ArrayList<>();
        Collections.addAll(expected, car1, car2, car3);
        Collections.sort(actual, Comparator.comparing(car -> car.getPrice()));
        assertEquals(expected, actual);
    }
    @Test
    public void mileageAscendingOrderSortTest() {
        Car car1 = new Car("Tesla", "X", 100, 2012, 1000);
        Car car2 = new Car("Tesla", "Y", 20, 2016, 2000);
        Car car3 = new Car("Tesla", "X3", 50, 2020, 5000);
        ArrayList<Car> actual = new ArrayList<>();
        Collections.addAll(actual, car1, car2, car3);
        ArrayList<Car> expected = new ArrayList<>();
        Collections.addAll(expected, car2, car3, car1);
        Collections.sort(actual, Comparator.comparing(car -> car.getMileage()));
        assertEquals(expected, actual);
    }
    @Test
    public void yearAscendingOrderSortTest() {
        Car car1 = new Car("Tesla", "X", 100, 2012, 1000);
        Car car2 = new Car("Tesla", "Y", 20, 2016, 2000);
        Car car3 = new Car("Tesla", "X3", 50, 2020, 5000);
        ArrayList<Car> actual = new ArrayList<>();
        Collections.addAll(actual, car1, car2, car3);
        ArrayList<Car> expected = new ArrayList<>();
        Collections.addAll(expected, car1, car2, car3);
        Collections.sort(actual, Comparator.comparing(car -> car.getYear()));
        assertEquals(expected, actual);
    }

    @Test
    public void paretoAscendingOrderSortTest() {
        Car car1 = new Car("Tesla", "X", 100, 2012, 1000);
        Car car2 = new Car("Tesla", "Y", 20, 2016, 2000);
        Car car3 = new Car("Tesla", "X3", 50, 2020, 5000);
        ArrayList<Car> actual = new ArrayList<>();
        Collections.addAll(actual, car1, car2, car3);
        ArrayList<Car> expected = new ArrayList<>();
        Collections.addAll(expected, car1, car2, car3);
        Collections.sort(actual, Comparator.comparing(car -> car.getPrice()));
        assertEquals(expected, actual);
    }
}
