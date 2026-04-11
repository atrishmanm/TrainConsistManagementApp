package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementApp {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] emptyBogies = {};
        // Verifies that the system throws IllegalStateException when searching an empty array
        assertThrows(IllegalStateException.class, () -> {
            main.TrainConsistManagementApp.searchWithValidation(emptyBogies, "BG101");
        }, "Should throw IllegalStateException when no bogies are available.");
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] bogieIds = {"BG101", "BG205"};
        // Verifies that search executes without exception when data is present
        assertDoesNotThrow(() -> {
            main.TrainConsistManagementApp.searchWithValidation(bogieIds, "BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        boolean result = main.TrainConsistManagementApp.searchWithValidation(bogieIds, "BG205");
        assertTrue(result, "Bogie should be found correctly after validation passes.");
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        boolean result = main.TrainConsistManagementApp.searchWithValidation(bogieIds, "BG999");
        assertFalse(result, "Should return false if validation passes but ID is not in the list.");
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] bogieIds = {"BG101"};
        boolean result = main.TrainConsistManagementApp.searchWithValidation(bogieIds, "BG101");
        assertTrue(result, "Search should work for a single-element array.");
    }
}