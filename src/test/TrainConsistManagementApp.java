package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementApp {

    @Test
    void testSearch_BogieFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchId = "BG309";
        
        // Accessing main package class using fully qualified name
        boolean result = main.TrainConsistManagementApp.linearSearch(bogieIds, searchId);
        
        assertTrue(result, "Search should return true for an existing bogie ID.");
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchId = "BG999";
        
        boolean result = main.TrainConsistManagementApp.linearSearch(bogieIds, searchId);
        
        assertFalse(result, "Search should return false for a non-existent bogie ID.");
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchId = "BG101";
        
        boolean result = main.TrainConsistManagementApp.linearSearch(bogieIds, searchId);
        
        assertTrue(result, "Search should return true when the first element matches.");
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchId = "BG550";
        
        boolean result = main.TrainConsistManagementApp.linearSearch(bogieIds, searchId);
        
        assertTrue(result, "Search should return true when the last element matches.");
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] bogieIds = {"BG101"};
        String searchId = "BG101";
        
        boolean result = main.TrainConsistManagementApp.linearSearch(bogieIds, searchId);
        
        assertTrue(result, "Search should work correctly for an array with a single element.");
    }
}