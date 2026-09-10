package constructors_and_java_keywords.class_problems;

import java.util.HashSet;
import java.util.Set;

public class BusTicket {
    private final String passengerName;
    private final String destination;
    private boolean isCheckedIn;

    public BusTicket(String passengerName, String destination) {
        if (passengerName == null || passengerName.trim().isEmpty() || !passengerName.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException("Invalid passenger name: " + passengerName);
        }
        if (destination == null || destination.trim().isEmpty() || !destination.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException("Invalid destination: " + destination);
        }
        this.passengerName = passengerName.trim();
        this.destination = destination.trim();
        this.isCheckedIn = false;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getDestination() {
        return destination;
    }

    public boolean isCheckedIn() {
        return isCheckedIn;
    }

    public void markCheckedIn() {
        if (this.isCheckedIn) {
            throw new IllegalStateException("Ticket already checked in for passenger: " + passengerName);
        }
        this.isCheckedIn = true;
    }

    public static void processBatch(String[][] rawBookings) {
        int valid = 0;
        int rejected = 0;
        int duplicates = 0;

        Set<String> acceptedBookings = new HashSet<>();

        if (rawBookings != null) {
            for (String[] booking : rawBookings) {
                if (booking == null || booking.length < 2) {
                    rejected++;
                    continue;
                }

                String pName = booking[0];
                String dest = booking[1];

                try {
                    // Test construction first to validate input
                    BusTicket ticket = new BusTicket(pName, dest);
                    String key = ticket.getPassengerName().toLowerCase() + "|" + ticket.getDestination().toLowerCase();

                    if (acceptedBookings.contains(key)) {
                        duplicates++;
                    } else {
                        acceptedBookings.add(key);
                        valid++;
                    }
                } catch (IllegalArgumentException e) {
                    rejected++;
                }
            }
        }

        System.out.printf("Valid: %d | Rejected: %d | Duplicates skipped: %d%n", valid, rejected, duplicates);
    }
}
