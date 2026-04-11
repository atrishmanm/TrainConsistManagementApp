package main;
public class TrainConsistManagementApp {

    /**
     * Performs Binary Search on a sorted array of bogie IDs.
     * @param bogieIds Array to search (must be sorted).
     * @param key The ID to find.
     * @return true if found, false otherwise.
     */
    public static boolean binarySearch(String[] bogieIds, String key) {
        if (bogieIds == null || bogieIds.length == 0) {
            return false;
        }

        // Precondition: Binary search requires sorted data
        // We ensure it is sorted here to handle the "Unsorted Input" requirement
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = key.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                return true; // Match found
            } else if (comparison > 0) {
                low = mid + 1; // Target is in the right half
            } else {
                high = mid - 1; // Target is in the left half
            }
        }
        return false; // Not found
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println(" UC19 - Binary Search for Bogie ID ");
        System.out.println("========================================\n");

        // Create array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Precondition: Ensure data is sorted
        Arrays.sort(bogieIds);

        // Search key
        String key = "BG309";

        // Display available bogies
        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }
        System.out.println();

        // ---- BINARY SEARCH LOGIC ----
        boolean found = binarySearch(bogieIds, key);

        if (found) {
            System.out.println("Bogie " + key + " found using Binary Search.");
        } else {
            System.out.println("Bogie " + key + " not found.");
        }

        System.out.println("\nUC17 sorting completed ...");
    }
}