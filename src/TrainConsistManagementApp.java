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

    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println("      UC13 - Performance Comparison (Loops vs Streams)     ");
        System.out.println("==========================================================\n");

        // Create Large test dataset
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 56));
        }

        // ---- LOOP BASED FILTERING ----
        long loopStart = System.nanoTime();
        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }
        long loopEnd = System.nanoTime();
        long loopDuration = loopEnd - loopStart;

        // ---- STREAM BASED FILTERING ----
        long streamStart = System.nanoTime();
        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.capacity > 60)
                .toList();
        long streamEnd = System.nanoTime();
        long streamDuration = streamEnd - streamStart;

        System.out.println("Loop Execution Time (ns): " + loopDuration);
        System.out.println("Stream Execution Time (ns): " + streamDuration);

        System.out.println("\nUC13 performance benchmarking completed ...");
    }
}