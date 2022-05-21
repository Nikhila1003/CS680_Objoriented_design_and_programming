package edu.umb.cs680.hw11;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

public class CarTest {

    @Test
    public void priceComparatorTest() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Tesla", "X", 100, 2012, 1000));
        cars.add(new Car("Tesla", "Y", 20, 2016, 2000));
        cars.add(new Car("Tesla", "C", 50, 2020, 5000));
        cars.add(new Car("Tesla", "A", 40, 2024, 4000));
        Collections.sort(cars, new PriceComparator());
        assertEquals(1000, cars.get(0).getPrice());
        assertEquals(2000, cars.get(1).getPrice());
        assertEquals(4000, cars.get(2).getPrice());
        assertEquals(5000, cars.get(3).getPrice());
    }
    @Test
    public void mileageComparatorTest() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Tesla", "X", 100, 2012, 1000));
        cars.add(new Car("Tesla", "Y", 20, 2016, 2000));
        cars.add(new Car("Tesla", "C", 50, 2020, 5000));
        cars.add(new Car("Tesla", "A", 40, 2024, 4000));
        Collections.sort(cars, new MileageComparator());
        assertEquals(20, cars.get(0).getMileage());
        assertEquals(40, cars.get(1).getMileage());
        assertEquals(50, cars.get(2).getMileage());
        assertEquals(100, cars.get(3).getMileage());
    }
    @Test
    public void yearComparatorTest() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Tesla", "X", 100, 2012, 1000));
        cars.add(new Car("Tesla", "Y", 20, 2016, 2000));
        cars.add(new Car("Tesla", "C", 50, 2020, 5000));
        cars.add(new Car("Tesla", "A", 40, 2024, 4000));
        Collections.sort(cars, new YearComparator());
        assertEquals(2012, cars.get(0).getYear());
        assertEquals(2016, cars.get(1).getYear());
        assertEquals(2020, cars.get(2).getYear());
        assertEquals(2024, cars.get(3).getYear());
    }
    @Test
    public void paretoComparatorTest() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Tesla", "X", 100, 2012, 1000));
        cars.add(new Car("Tesla", "Y", 20, 2016, 2000));
        cars.add(new Car("Tesla", "C", 50, 2020, 5000));
        cars.add(new Car("Tesla", "A", 40, 2024, 4000));
        for(Car car : cars) {
            car.setDominationCount(cars);
        }
        Collections.sort(cars, new ParetoComparator());
        assertEquals(1000, cars.get(0).getPrice());
        assertEquals(20, cars.get(1).getMileage());
        assertEquals(2024, cars.get(2).getYear());
        assertEquals("A", cars.get(2).getMake());
        assertEquals("Tesla", cars.get(3).getModel());
    }
}
