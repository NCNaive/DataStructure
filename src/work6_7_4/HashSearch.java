package work6_7_4;
import java.util.*;

public class HashSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int M = scanner.nextInt();
            int K = scanner.nextInt();
            int[] keys = new int[n];
            for (int i = 0; i < n; i++) {
                keys[i] = scanner.nextInt();
            }

            for (int i = 0; i < n; i++) {
                keys[i] = keys[i] % M;
            }

            double successAvgLength = calculateSuccessAvgLength(keys, M, K);
            double failAvgLength = calculateFailAvgLength(keys, M, K);

            System.out.printf("%.2f %.2f\n", successAvgLength, failAvgLength);
        }
    }

    private static double calculateSuccessAvgLength(int[] keys, int M, int K) {
        int[] hashTable = new int[M];
        Arrays.fill(hashTable, -1);
        int sum = 0;

        for (int key : keys) {
            int index = key % M;
            int count = 1;
            while (hashTable[index] != -1) {
                index = (index + K) % M;
                count++;
            }
            hashTable[index] = key;
            sum += count;
        }

        return (double) sum / keys.length;
    }

    private static double calculateFailAvgLength(int[] keys, int M, int K) {
        int[] hashTable = new int[M];
        Arrays.fill(hashTable, -1);
        int sum = 0;

        for (int key : keys) {
            int index = key % M;
            int count = 1;
            while (hashTable[index] != -1 && hashTable[index] != key) {
                index = (index + K) % M;
                count++;
            }
            if (hashTable[index] == -1) {
                hashTable[index] = key;
            } else {
                count = M;
            }
            sum += count;
        }

        return (double) sum / keys.length;
    }
}