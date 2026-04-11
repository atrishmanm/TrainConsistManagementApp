package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementApp {

    @Test
    void testBinarySearch_BogieFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(main.TrainConsistManagementApp.binarySearch(bogieIds, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(main.TrainConsistManagementApp.binarySearch(bogieIds, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(main.TrainConsistManagementApp.binarySearch(bogieIds, "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(main.TrainConsistManagementApp.binarySearch(bogieIds, "BG550"));
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] bogieIds = {"BG101"};
        assertTrue(main.TrainConsistManagementApp.binarySearch(bogieIds, "BG101"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] bogieIds = {};
        assertFalse(main.TrainConsistManagementApp.binarySearch(bogieIds, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        // Input is unsorted; logic should handle sorting first
        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        assertTrue(main.TrainConsistManagementApp.binarySearch(bogieIds, "BG205"));
    }
}