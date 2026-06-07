import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        long[] students = new long[n];
        Map<String, Long> timeTotals = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String timeSlot = sc.next();
            long count = sc.nextLong();

            students[i] = count;
            timeTotals.put(timeSlot, timeTotals.getOrDefault(timeSlot, 0L) + count);
        }

        // Sliding Window to find the maximum sum in K consecutive hours
        long currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += students[i];
        }
        long maxSum = currentSum;

        for (int i = k; i < n; i++) {
            currentSum += students[i] - students[i - k];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        // Find the time slot with the highest total number of students
        long maxSlotTotal = -1;
        String bestSlot = "";

        for (Map.Entry<String, Long> entry : timeTotals.entrySet()) {
            String slot = entry.getKey();
            long total = entry.getValue();

            if (total > maxSlotTotal) {
                maxSlotTotal = total;
                bestSlot = slot;
            } else if (total == maxSlotTotal) {
                // Handle tie-break in lexicographical order (A-Z)
                if (bestSlot.isEmpty() || slot.compareTo(bestSlot) < 0) {
                    bestSlot = slot;
                }
            }
        }

        // Print the results
        System.out.println(maxSum);
        System.out.println(bestSlot);
        sc.close();
    }
}