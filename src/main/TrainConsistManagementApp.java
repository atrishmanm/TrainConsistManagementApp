public class TrainConsistManagementApp {

    // Helper method for Bubble Sort to be used by main and tests
    public static void bubbleSort(int[] array) {
        int n = array.length;
        // Outer loop controls number of passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for adjacent comparisons
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if left element is greater than right element
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println(" UC16 - Manual Sorting using Bubble Sort ");
        System.out.println("========================================\n");

        // Create array of passenger bogie capacities
        int[] capacities = {72, 56, 24, 70, 60};

        // Display original order
        System.out.println("Original Capacities:");
        for (int c : capacities) {
            System.out.print(c + " ");
        }

        // ---- BUBBLE SORT LOGIC ----
        bubbleSort(capacities);

        // Display sorted result
        System.out.println("\n\nSorted Capacities (Ascending):");
        for (int c : capacities) {
            System.out.print(c + " ");
        }

        System.out.println("\n\nUC16 sorting completed ...");
        System.out.println("========================================\n");
    }
}