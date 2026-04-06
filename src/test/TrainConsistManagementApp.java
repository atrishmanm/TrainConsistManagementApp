package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementApp {

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] names = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        String[] expected = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};
        
        // Accessing the main class method
        main.TrainConsistManagementApp.sortBogieNames(names);
        
        assertArrayEquals(expected, names);
    }

    @Test
    void testSort_UnsortedInput() {
        String[] names = {"Luxury", "General", "Sleeper", "AC Chair"};
        String[] expected = {"AC Chair", "General", "Luxury", "Sleeper"};
        
        main.TrainConsistManagementApp.sortBogieNames(names);
        
        assertArrayEquals(expected, names);
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] names = {"AC Chair", "First Class", "General"};
        String[] expected = {"AC Chair", "First Class", "General"};
        
        main.TrainConsistManagementApp.sortBogieNames(names);
        
        assertArrayEquals(expected, names);
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] names = {"Sleeper", "AC Chair", "Sleeper", "General"};
        String[] expected = {"AC Chair", "General", "Sleeper", "Sleeper"};
        
        main.TrainConsistManagementApp.sortBogieNames(names);
        
        assertArrayEquals(expected, names);
    }

    @Test
    void testSort_SingleElementArray() {
        String[] names = {"Sleeper"};
        String[] expected = {"Sleeper"};
        
        main.TrainConsistManagementApp.sortBogieNames(names);
        
        assertArrayEquals(expected, names);
    }
}