package test;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    private int calculateTotalCapacity(List<Bogie> list) {
        return list.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    @Test
    public void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        
        int total = calculateTotalCapacity(bogies);
        assertEquals(128, total);
    }

    @Test
    public void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("S1", 10));
        bogies.add(new Bogie("S2", 20));
        bogies.add(new Bogie("S3", 30));
        
        int total = calculateTotalCapacity(bogies);
        assertEquals(60, total);
    }

    @Test
    public void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Solo", 50));
        
        int total = calculateTotalCapacity(bogies);
        assertEquals(50, total);
    }

    @Test
    public void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();
        int total = calculateTotalCapacity(bogies);
        assertEquals(0, total);
    }

    @Test
    public void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = new ArrayList<>();
        Bogie b = new Bogie("Test", 100);
        bogies.add(b);
        
        int total = calculateTotalCapacity(bogies);
        assertEquals(b.capacity, total);
    }

    @Test
    public void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            bogies.add(new Bogie("Bogie" + i, 10));
        }
        
        int total = calculateTotalCapacity(bogies);
        assertEquals(50, total);
    }

    @Test
    public void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        int originalSize = bogies.size();
        
        calculateTotalCapacity(bogies);
        
        assertEquals(originalSize, bogies.size());
        assertEquals(72, bogies.get(0).capacity);
    }
}