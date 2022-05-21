package edu.umb.cs680.hw11;

import java.util.Comparator;

public class ParetoComparator implements Comparator<Car> {

    public int compare(Car carOne, Car carTwo) {
        if((carOne.getPrice() <= carTwo.getPrice() && carOne.getYear() >= carTwo.getYear() && carOne.getMileage() <= carTwo.getMileage())
                && (carOne.getPrice() < carTwo.getPrice() || carOne.getYear() > carTwo.getYear() || carOne.getMileage() < carTwo.getMileage())) {
            return -1;
        }
        return 0;
    }

}
