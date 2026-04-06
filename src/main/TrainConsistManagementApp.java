package main;

public class TrainConsistManagementApp {

    /**
     * Performs a Linear Search to find a specific bogie ID in an array.
     * @param bogieIds Array of bogie IDs to search through.
     * @param searchId The ID to look for.
     * @return true if found, false otherwise.
     */
    public static boolean linearSearch(String[] bogieIds, String searchId) {
        // ---- LINEAR SEARCH LOGIC ----
        // Traverse each element sequentially
        for (String id : bogieIds) {
            // Compare each ID using equals() for string safety
            if (id.equals(searchId)) {
                return true; // Early termination once match is found
            }
        }
        return false; // Result if entire array is traversed without a match
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println(" UC18 - Linear Search for Bogie ID ");
        System.out.println("========================================\n");

        // Create array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Bogie ID to search
        String searchId = "BG309";

        // Display all bogies
        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }
        System.out.println();

        // Perform search
        boolean found = linearSearch(bogieIds, searchId);

        // Display result
        if (found) {
            System.out.println("Bogie " + searchId + " found in train consist.");
        } else {
            System.out.println("Bogie " + searchId + " not found in train consist.");
        }

        System.out.println("\nUC18 search completed ...");
        System.out.println("========================================");
    }
}