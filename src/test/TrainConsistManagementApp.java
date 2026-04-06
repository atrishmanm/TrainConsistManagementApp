import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    private static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    @Test
    void testSort_BasicSorting() {
        int[] capacities = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};
        bubbleSort(capacities);
        assertArrayEquals(expected, capacities);
    }

    @Test
    void testSort_AlreadySortedArray() {
        int[] capacities = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};
        bubbleSort(capacities);
        assertArrayEquals(expected, capacities);
    }

    @Test
    void testSort_DuplicateValues() {
        int[] capacities = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};
        bubbleSort(capacities);
        assertArrayEquals(expected, capacities);
    }

    @Test
    void testSort_SingleElementArray() {
        int[] capacities = {50};
        int[] expected = {50};
        bubbleSort(capacities);
        assertArrayEquals(expected, capacities);
    }

    @Test
    void testSort_AllEqualValues() {
        int[] capacities = {40, 40, 40};
        int[] expected = {40, 40, 40};
        bubbleSort(capacities);
        assertArrayEquals(expected, capacities);
    }
}