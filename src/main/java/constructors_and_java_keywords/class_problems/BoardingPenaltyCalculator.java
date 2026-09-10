package constructors_and_java_keywords.class_problems;

public final class BoardingPenaltyCalculator {
    private final double minimumPenaltyPercent;

    public BoardingPenaltyCalculator(double minimumPenaltyPercent) {
        if (minimumPenaltyPercent < 0) {
            throw new IllegalArgumentException("Minimum penalty percent cannot be negative.");
        }
        this.minimumPenaltyPercent = minimumPenaltyPercent;
    }

    public final double calculatePenalty(double ticketFare, int minutesLate) {
        if (ticketFare < 0 || minutesLate < 0) {
            throw new IllegalArgumentException("Ticket fare and minutes late must not be negative.");
        }
        if (minutesLate == 0) {
            return 0.0;
        }

        int m1 = Math.min(minutesLate, 5);
        int m2 = Math.max(0, Math.min(minutesLate - 5, 10));
        int m3 = Math.max(0, minutesLate - 15);

        double tieredPenalty = (m1 * 0.005 + m2 * 0.01 + m3 * 0.02) * ticketFare;
        double floorPenalty = (minimumPenaltyPercent / 100.0) * ticketFare;

        return Math.max(tieredPenalty, floorPenalty);
    }
}
