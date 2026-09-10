package session1.assigment_problems;

public class TrafficSignalStreakAnalyzer {

    /**
     * Scans through signal readings and prints the longest continuous streak of the same color.
     * @param signalLog String of signal readings (e.g., "RRGGGYRR")
     */
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No signal log provided.");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int maxStreak = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char ch = signalLog.charAt(i);
            if (ch == currentColor) {
                currentStreak++;
            } else {
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    longestColor = currentColor;
                }
                currentColor = ch;
                currentStreak = 1;
            }
        }

        // Final check after loop end
        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            longestColor = currentColor;
        }

        System.out.printf("Longest Streak: '%c' repeated %d times%n", longestColor, maxStreak);
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1:");
        findLongestStreak("RRGGGYRR");

        System.out.println("\nTest Case 2:");
        findLongestStreak("RRRRYYGG");
    }
}
