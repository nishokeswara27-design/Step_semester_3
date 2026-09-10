package constructors_and_java_keywords.class_problems;

public class BusTicketAccount {
    private final String bookingId;
    private final double ticketFare;
    private static final BoardingPenaltyCalculator CALCULATOR;

    static {
        // One-time class level initialization using static block
        CALCULATOR = new BoardingPenaltyCalculator(1.0);
    }

    public BusTicketAccount(String bookingId, double ticketFare) {
        if (bookingId == null || bookingId.trim().isEmpty()) {
            throw new IllegalArgumentException("Booking ID cannot be null or empty.");
        }
        if (ticketFare < 0) {
            throw new IllegalArgumentException("Ticket fare cannot be negative.");
        }
        this.bookingId = bookingId.trim();
        this.ticketFare = ticketFare;
    }

    public BusTicketAccount(String bookingId) {
        this(bookingId, 0.0);
    }

    public String getBookingId() {
        return bookingId;
    }

    public double getTicketFare() {
        return ticketFare;
    }

    public final double calculatePenalty(int minutesLate) {
        return CALCULATOR.calculatePenalty(ticketFare, minutesLate);
    }

    public void processAccount(BusTicketAccount account, double amount, int minutesLate) {
        if (account != null) {
            double penalty = account.calculatePenalty(minutesLate);
            System.out.printf("Processed %s: Fare Rs %.2f, Penalty Rs %.2f%n", account.getBookingId(), amount, penalty);
        }
    }

    public static void processBatch(BusTicketAccount[] accounts, double[] amounts, int[] minutesLateArray) {
        if (accounts == null || amounts == null || minutesLateArray == null) {
            System.out.println("Invalid batch input arrays.");
            return;
        }

        int limit = Math.min(accounts.length, Math.min(amounts.length, minutesLateArray.length));
        int processed = 0;
        int nullSkipped = 0;
        int sleeperCount = 0;
        int regularCount = 0;
        double grandTotalPenalties = 0.0;

        for (int i = 0; i < limit; i++) {
            BusTicketAccount account = accounts[i];
            if (account == null) {
                nullSkipped++;
                continue;
            }

            processed++;
            double fare = amounts[i] > 0 ? amounts[i] : account.getTicketFare();
            int delay = minutesLateArray[i];

            // Sleeper accounts get calculated using their account fare or penalty logic
            double penalty;
            if (account instanceof Sleeper) {
                sleeperCount++;
                penalty = account.calculatePenalty(delay);
            } else {
                regularCount++;
                penalty = account.calculatePenalty(delay);
            }

            grandTotalPenalties += penalty;
        }

        // Count any remaining null entries if accounts array was longer
        if (accounts.length > limit) {
            for (int i = limit; i < accounts.length; i++) {
                if (accounts[i] == null) {
                    nullSkipped++;
                }
            }
        }

        System.out.printf("%d processed | %d null skipped | %d sleeper | %d regular | grand total penalties = Rs %.1f%n",
                processed, nullSkipped, sleeperCount, regularCount, grandTotalPenalties);
    }
}

class Sleeper extends BusTicketAccount {
    public Sleeper(String bookingId, double ticketFare) {
        super(bookingId, ticketFare);
    }

    public Sleeper(String bookingId) {
        super(bookingId, 0.0);
    }
}
