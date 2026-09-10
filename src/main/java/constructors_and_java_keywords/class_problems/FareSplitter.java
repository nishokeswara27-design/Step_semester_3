package constructors_and_java_keywords.class_problems;

import java.util.Arrays;

public class FareSplitter {
    private final String tripId;
    private final double totalFare;
    private final int passengerCount;

    public FareSplitter(String tripId, double totalFare, int passengerCount) {
        if (tripId == null || tripId.trim().isEmpty()) {
            throw new IllegalArgumentException("Trip ID cannot be null or empty.");
        }
        if (totalFare < 0) {
            throw new IllegalArgumentException("Total fare cannot be negative.");
        }
        if (passengerCount <= 0) {
            throw new IllegalArgumentException("Passenger count must be greater than zero.");
        }
        this.tripId = tripId.trim();
        this.totalFare = totalFare;
        this.passengerCount = passengerCount;
    }

    public FareSplitter(String tripId, double totalFare) {
        this(tripId, totalFare, 2);
    }

    public FareSplitter(String tripId) {
        this(tripId, 0.0, 2);
    }

    public String getTripId() {
        return tripId;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public double[] fareBreakdown() {
        double[] breakdown = new double[passengerCount];
        long totalCents = Math.round(totalFare * 100.0);
        long baseCents = totalCents / passengerCount;
        long remainderCents = totalCents % passengerCount;

        for (int i = 0; i < passengerCount; i++) {
            // Distribute remainder cents to the last passengers to match requirement
            long passengerCents = baseCents + (i >= passengerCount - remainderCents ? 1 : 0);
            breakdown[i] = passengerCents / 100.0;
        }

        return breakdown;
    }

    public boolean isConfirmationOverdue(int confirmed, int expected) {
        return confirmed < expected;
    }
}
