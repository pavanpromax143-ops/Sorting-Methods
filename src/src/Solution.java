import java.util.*;

public class Solution {

    // ---------------- Linear Search ----------------
    public static void linearSearch(String[] logs, String target) {
        int first = -1, last = -1;
        int comparisons = 0;

        for (int i = 0; i < logs.length; i++) {
            comparisons++;
            if (logs[i].equals(target)) {
                if (first == -1) first = i;
                last = i;
            }
        }

        System.out.println("Linear Search:");
        if (first != -1) {
            System.out.println("First occurrence at index: " + first);
            System.out.println("Last occurrence at index: " + last);
        } else {
            System.out.println("Account not found");
        }
        System.out.println("Comparisons: " + comparisons);
    }

    // ---------------- Binary Search ----------------
    public static void binarySearch(String[] logs, String target) {
        int low = 0, high = logs.length - 1;
        int comparisons = 0;
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            int cmp = logs[mid].compareTo(target);

            if (cmp == 0) {
                index = mid;
                break;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("\nBinary Search:");

        if (index == -1) {
            System.out.println("Account not found");
            System.out.println("Comparisons: " + comparisons);
            return;
        }

        // Count occurrences (expand left and right)
        int count = 1;
        int left = index - 1;
        int right = index + 1;

        while (left >= 0 && logs[left].equals(target)) {
            comparisons++;
            count++;
            left--;
        }

        while (right < logs.length && logs[right].equals(target)) {
            comparisons++;
            count++;
            right++;
        }

        System.out.println("One occurrence at index: " + index);
        System.out.println("Total occurrences: " + count);
        System.out.println("Comparisons: " + comparisons);
    }

    // ---------------- Utility Print ----------------
    public static void printArray(String[] arr) {
        for (String s : arr)
            System.out.print(s + " ");
        System.out.println();
    }

    // ---------------- Main Method ----------------
    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        System.out.println("Original Logs:");
        printArray(logs);

        // Linear search on unsorted data
        linearSearch(logs, "accB");

        // Sort logs for binary search
        Arrays.sort(logs);

        System.out.println("\nSorted Logs:");
        printArray(logs);

        // Binary search on sorted data
        binarySearch(logs, "accB");
    }
}