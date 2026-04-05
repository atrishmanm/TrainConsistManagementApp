package test;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    @Test
    public void testLoopFilteringLogic() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC", 50));

        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) result.add(b);
        }

        assertEquals(1, result.size());
        assertEquals(72, result.get(0).capacity);
    }

    @Test
    public void testStreamFilteringLogic() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC", 50));

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 60)
                .toList();

        assertEquals(1, result.size());
        assertEquals(72, result.get(0).capacity);
    }

    @Test
    public void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("T1", 80));
        bogies.add(new Bogie("T2", 40));

        // Loop
        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) if (b.capacity > 60) loopResult.add(b);

        // Stream
        List<Bogie> streamResult = bogies.stream().filter(b -> b.capacity > 60).toList();

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    public void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        // Small delay
        for(int i=0; i<100; i++);
        long end = System.nanoTime();
        
        assertTrue((end - start) > 0);
    }

    @Test
    public void testLargeDatasetProcessing() {
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            bogies.add(new Bogie("Type", i % 100));
        }

        long count = bogies.stream().filter(b -> b.capacity > 60).count();
        assertTrue(count > 0);
    }
}