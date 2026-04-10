
import java.util.*;

public class Solution {

    // ---------------- Linear Search ----------------
    public static void linearSearch(int[] arr, int target) {
        int comparisons = 0;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear Search: Found at index " + i);
                found = true;
                break;
            }
        }

        if (!found)
            System.out.println("Linear Search: Threshold not found");

        System.out.println("Comparisons: " + comparisons);
    }

    // ---------------- Binary Search: Floor & Ceiling ----------------
    public static void binaryFloorCeiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int floor = -1, ceiling = -1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] == target) {
                floor = ceiling = arr[mid];
                break;
            }
            else if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            }
            else {
                ceiling = arr[mid];
                high = mid - 1;
            }
        }

        System.out.println("\nBinary Search:");
        System.out.println("Floor value: " + (floor == -1 ? "None" : floor));
        System.out.println("Ceiling value: " + (ceiling == -1 ? "None" : ceiling));
        System.out.println("Comparisons: " + comparisons);
    }

    // ---------------- Binary Search: Insertion Point ----------------
    public static void findInsertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length;
        int comparisons = 0;

        while (low < high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }

        System.out.println("Insertion point for " + target + " is index: " + low);
        System.out.println("Comparisons: " + comparisons);
    }

    // ---------------- Utility Print ----------------
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    // ---------------- Main Method ----------------
    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100};
        int threshold = 30;

        System.out.println("Sorted Risk Bands:");
        printArray(risks);

        // Linear search (works on unsorted too)
        linearSearch(risks, threshold);

        // Binary search floor & ceiling
        binaryFloorCeiling(risks, threshold);

        // Binary insertion point
        findInsertionPoint(risks, threshold);
    }
}
