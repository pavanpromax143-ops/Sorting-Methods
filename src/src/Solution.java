import java.util.*;

public class Solution {

    // ---------------- Client Class ----------------
    static class Client {
        String name;
        int riskScore;
        double accountBalance;

        Client(String name, int riskScore, double accountBalance) {
            this.name = name;
            this.riskScore = riskScore;
            this.accountBalance = accountBalance;
        }

        public String toString() {
            return name + " : Risk=" + riskScore + ", Balance=" + accountBalance;
        }
    }

    // ---------------- Bubble Sort ----------------
    // Sort ascending by risk score and visualize swaps
    public static void bubbleSortAscending(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {

                    // visualize swap
                    System.out.println("Swapping " + arr[j].name + " and " + arr[j + 1].name);

                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        System.out.println("Total swaps: " + swaps);
    }

    // ---------------- Insertion Sort ----------------
    // Sort by riskScore DESC, if equal then by accountBalance DESC
    public static void insertionSortDescending(Client[] arr) {

        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 &&
                    (arr[j].riskScore < key.riskScore ||
                            (arr[j].riskScore == key.riskScore &&
                                    arr[j].accountBalance < key.accountBalance))) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // ---------------- Print Utility ----------------
    public static void printArray(Client[] arr) {
        for (Client c : arr)
            System.out.println(c);
    }

    // ---------------- Top Risk Clients ----------------
    public static void printTopRisk(Client[] arr, int k) {
        System.out.println("\nTop " + k + " Highest Risk Clients:");
        for (int i = 0; i < Math.min(k, arr.length); i++) {
            System.out.println(arr[i]);
        }
    }

    // ---------------- Main Method ----------------
    public static void main(String[] args) {

        Client[] clients = {
                new Client("clientC", 80, 20000),
                new Client("clientA", 20, 5000),
                new Client("clientB", 50, 12000)
        };

        System.out.println("Original Data:");
        printArray(clients);

        // ---------------- Bubble Sort Demo ----------------
        System.out.println("\nBubble Sort (Ascending Risk):");
        bubbleSortAscending(clients);
        printArray(clients);

        // ---------------- Insertion Sort Ranking ----------------
        System.out.println("\nInsertion Sort (Descending Risk + Balance):");
        insertionSortDescending(clients);
        printArray(clients);

        // ---------------- Top Risk ----------------
        printTopRisk(clients, 10);
    }
}