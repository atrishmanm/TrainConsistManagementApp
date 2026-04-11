package main;

public class TrainConsistManagementApp {

    /**
     * Performs a search with fail-fast state validation.
     * @param bogieIds Array of bogie IDs to search.
     * @param searchId The ID to look for.
     * @return true if found, false otherwise.
     * @throws IllegalStateException if the array is empty.
     */
    public static boolean searchWithValidation(String[] bogieIds, String searchId) {
        // ---- FAIL-FAST VALIDATION ----
        // Check if train has bogies before performing search
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }

        // ---- SEARCH LOGIC (executes only if data exists) ----
        boolean found = false;
        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        System.out.println("UC20 - Exception Handling During Search\n");

        // Create bogie array (empty train scenario to demonstrate exception)
        String[] bogieIds = {};
        String searchId = "BG101";

        try {
            boolean found = searchWithValidation(bogieIds, searchId);
            
            if (found) {
                System.out.println("Bogie " + searchId + " found in train consist.");
            } else {
                System.out.println("Bogie " + searchId + " not found.");
            }
        } catch (IllegalStateException e) {
            // Re-throwing to match the expected console output behavior in the UC description
            throw e;
        }

        System.out.println("\nUC20 execution completed ... ");
    }
}