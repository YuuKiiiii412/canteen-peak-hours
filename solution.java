import java.util.*;

public class solution {

    static class HourRecord {
        String timeSlot;
        int students;

        public HourRecord(String timeSlot, int students) {
            this.timeSlot = timeSlot;
            this.students = students;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        HourRecord[] records = new HourRecord[N];

        HashMap<String, Long> totalByTimeSlot = new HashMap<>();

        for (int i = 0; i < N; i++) {

            String timeSlot = sc.next();
            int students = sc.nextInt();

            records[i] = new HourRecord(timeSlot, students);

            totalByTimeSlot.put(
                    timeSlot,
                    totalByTimeSlot.getOrDefault(timeSlot, 0L) + students);
        }

        long windowSum = 0;

        for (int i = 0; i < K; i++) {
            windowSum += records[i].students;
        }

        long maxSum = windowSum;

        for (int i = K; i < N; i++) {
            windowSum -= records[i - K].students;
            windowSum += records[i].students;
            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
        }
        String bestSlot = null;
        long bestTotal = -1;

        for (String slot : totalByTimeSlot.keySet()) {
            long total = totalByTimeSlot.get(slot);
            if (total > bestTotal) {
                bestTotal = total;
                bestSlot = slot;
            } else if (total == bestTotal &&
                    slot.compareTo(bestSlot) < 0) {
                bestSlot = slot;
            }
        }
        System.out.println(maxSum);
        System.out.println(bestSlot);
    }
}
