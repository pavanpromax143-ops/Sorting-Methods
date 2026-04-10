import java.util.*;
import java.time.LocalTime;

public class Solution {

    // ---------------- Transaction Class ----------------
    static class Transaction {
        String id;
        double fee;
        LocalTime timestamp;

        Transaction(String id, double fee, LocalTime timestamp) {
            this.id = id;
            this.fee = fee;
            this.timestamp = timestamp;
        }

        public String toString() {
            return id + " : $" + fee + " @ " + timestamp;
        }
    }

    // ---------------- Bubble Sort ----------------
    // Sort by fee only (stable)
    public static void bubbleSortByFee(ArrayList<Transaction> list) {
        int n = list.size();
        int passes = 0;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            passes++;

            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Transaction temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break; // early termination
        }

        System.out.println("Bubble Sort Passes: " + passes);
        System.out.println("Bubble Sort Swaps: " + swaps);
    }

    // ---------------- Insertion Sort ----------------
    // Sort by fee + timestamp (stable)
    public static void insertionSort(ArrayList<Transaction> list) {
        int shifts = 0;

        for (int i = 1; i < list.size(); i++) {
            Transaction key = list.get(i);
            int j = i - 1;

            while (j >= 0 &&
                    (list.get(j).fee > key.fee ||
                            (list.get(j).fee == key.fee &&
                                    list.get(j).timestamp.isAfter(key.timestamp)))) {

                list.set(j + 1, list.get(j));
                j--;
                shifts++;
            }

            list.set(j + 1, key);
        }

        System.out.println("Insertion Sort Shifts: " + shifts);
    }

    // ---------------- Outlier Detection ----------------
    public static void flagHighFee(ArrayList<Transaction> list) {
        System.out.println("\nHigh-fee outliers (> $50):");
        boolean found = false;

        for (Transaction t : list) {
            if (t.fee > 50) {
                System.out.println(t);
                found = true;
            }
        }

        if (!found) {
            System.out.println("None");
        }
    }

    // ---------------- Utility Print ----------------
    public static void printList(ArrayList<Transaction> list) {
        for (Transaction t : list) {
            System.out.println(t);
        }
    }

    // ---------------- Main Method ----------------
    public static void main(String[] args) {

        ArrayList<Transaction> transactions = new ArrayList<>();

        // Sample input
        transactions.add(new Transaction("id1", 10.5, LocalTime.of(10, 0)));
        transactions.add(new Transaction("id2", 25.0, LocalTime.of(9, 30)));
        transactions.add(new Transaction("id3", 5.0, LocalTime.of(10, 15)));

        System.out.println("Original Transactions:");
        printList(transactions);

        int size = transactions.size();

        if (size <= 100) {
            bubbleSortByFee(transactions);
            System.out.println("\nSorted by Fee (Bubble Sort):");
        } else if (size <= 1000) {
            insertionSort(transactions);
            System.out.println("\nSorted by Fee + Timestamp (Insertion Sort):");
        } else {
            System.out.println("Batch too large for quadratic sorts.");
        }

        printList(transactions);

        flagHighFee(transactions);
    }
}