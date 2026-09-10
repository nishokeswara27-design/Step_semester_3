package constructors_and_java_keywords.assigment_problems;

public final class SurgeFeeCalculator {
    private final double minimumSurgePercent;

    public SurgeFeeCalculator(double minimumSurgePercent) {
        if (minimumSurgePercent < 0) {
            throw new IllegalArgumentException("Minimum surge percent cannot be negative.");
        }
        this.minimumSurgePercent = minimumSurgePercent;
    }

    public final double calculateSurgeFee(double orderValue, int delayMinutes) {
        if (orderValue < 0 || delayMinutes < 0) {
            throw new IllegalArgumentException("Order value and delay minutes must not be negative.");
        }
        if (delayMinutes == 0) {
            return 0.0;
        }

        int m1 = Math.min(delayMinutes, 5);
        int m2 = Math.max(0, Math.min(delayMinutes - 5, 10));
        int m3 = Math.max(0, delayMinutes - 15);

        double tieredSurge = (m1 * 0.005 + m2 * 0.01 + m3 * 0.02) * orderValue;
        double floorSurge = (minimumSurgePercent / 100.0) * orderValue;

        return Math.max(tieredSurge, floorSurge);
    }
}
