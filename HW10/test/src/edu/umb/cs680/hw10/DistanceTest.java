package edu.umb.cs680.hw10;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DistanceTest {

    @Test
    public void testGetWithEuclidean() {
        List<Double> p1 = new ArrayList<>();
        Collections.addAll(p1, 10.0, 12.0, 15.0);

        List<Double> p2 = new ArrayList<>();
        Collections.addAll(p2, 10.0, 10.0, 10.0);

        double actual = Distance.get(p1, p2, new Euclidean());
        double expected = Math.sqrt(29.0);

        assertEquals(expected, actual);

    }
    @Test
    public void testGetWithManhattan() {
        List<Double> p1 = new ArrayList<>();
        Collections.addAll(p1, 10.0, 12.0, 15.0);

        List<Double> p2 = new ArrayList<>();
        Collections.addAll(p2, 10.0, 10.0, 10.0);

        double actual = Distance.get(p1, p2, new Manhattan());
        double expected = 7.0;

        assertEquals(expected, actual);

    }
    @Test
    public void testMatrixWithEuclidean() {
        List<List<Double>> points = new ArrayList<>();
        Collections.addAll(points, Arrays.asList(5.0, 10.0, 15.0), Arrays.asList(20.0, 25.0, 20.0),
                Arrays.asList(5.0, 10.0, 20.0), Arrays.asList(10.0, 20.0, 30.0), Arrays.asList(5.0, 15.0, 25.0));

        List<List<Double>> actual = Distance.matrix(points, new Euclidean());
        List<List<Double>> expected = new ArrayList<>();
        Collections.addAll(expected, Arrays.asList(0.0, Math.sqrt(475.0), Math.sqrt(25.0), Math.sqrt(350.0), Math.sqrt(125.0)),
                Arrays.asList(Math.sqrt(475.0), 0.0, Math.sqrt(450.0), Math.sqrt(225.0), Math.sqrt(350.0)),
                Arrays.asList(Math.sqrt(25.0), Math.sqrt(450.0), 0.0, Math.sqrt(225.0), Math.sqrt(50.0)),
                Arrays.asList(Math.sqrt(350.0), Math.sqrt(225.0), Math.sqrt(225.0), 0.0, Math.sqrt(75.0)),
                Arrays.asList(Math.sqrt(125.0), Math.sqrt(350.0), Math.sqrt(50.0), Math.sqrt(75.0), 0.0));

        assertEquals(expected, actual);

    }
    @Test
    public void testMatrixWithManhattan() {
        List<List<Double>> points = new ArrayList<>();
        Collections.addAll(points, Arrays.asList(5.0, 10.0, 15.0), Arrays.asList(20.0, 25.0, 20.0),
                Arrays.asList(5.0, 10.0, 20.0), Arrays.asList(10.0, 20.0, 30.0), Arrays.asList(5.0, 15.0, 25.0));

        List<List<Double>> actual = Distance.matrix(points, new Manhattan());
        List<List<Double>> expected = new ArrayList<>();
        Collections.addAll(expected, Arrays.asList(0.0, 35.0, 5.0, 30.0, 15.0), Arrays.asList(35.0, 0.0, 30.0, 25.0, 30.0),
                Arrays.asList(5.0, 30.0, 0.0, 25.0, 10.0), Arrays.asList(30.0, 25.0, 25.0, 0.0, 15.0),
                Arrays.asList(15.0, 30.0, 10.0, 15.0, 0.0));

        assertEquals(expected, actual);

    }

}
