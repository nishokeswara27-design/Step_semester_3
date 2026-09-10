package constructors_and_java_keywords.assigment_problems;

public class DeliveryAccount {
    private final String studentId;
    private final double orderValue;
    private static final SurgeFeeCalculator CALCULATOR;

    static {
        // One-time class level initialization using static block
        CALCULATOR = new SurgeFeeCalculator(1.0);
    }

    public DeliveryAccount(String studentId, double orderValue) {
        if (studentId == null || studentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be null or empty.");
        }
        if (orderValue < 0) {
            throw new IllegalArgumentException("Order value cannot be negative.");
        }
        this.studentId = studentId.trim();
        this.orderValue = orderValue;
    }

    public DeliveryAccount(String studentId) {
        this(studentId, 0.0);
    }

    public String getStudentId() {
        return studentId;
    }

    public double getOrderValue() {
        return orderValue;
    }

    public final double calculateSurgeFee(int delayMinutes) {
        return CALCULATOR.calculateSurgeFee(orderValue, delayMinutes);
    }

    public void processAccount(DeliveryAccount account, double amount, int delayMinutes) {
        if (account != null) {
            double surge = account.calculateSurgeFee(delayMinutes);
            System.out.printf("Processed %s: Order Value Rs %.2f, Surge Fee Rs %.2f%n", account.getStudentId(), amount, surge);
        }
    }

    public static void processBatch(DeliveryAccount[] accounts, double[] amounts, int[] delayMinutesArray) {
        if (accounts == null || amounts == null || delayMinutesArray == null) {
            System.out.println("Invalid batch input arrays.");
            return;
        }

        int limit = Math.min(accounts.length, Math.min(amounts.length, delayMinutesArray.length));
        int processed = 0;
        int nullSkipped = 0;
        int premiumCount = 0;
        int regularCount = 0;
        double grandTotalSurgeFees = 0.0;

        for (int i = 0; i < limit; i++) {
            DeliveryAccount account = accounts[i];
            if (account == null) {
                nullSkipped++;
                continue;
            }

            processed++;
            int delay = delayMinutesArray[i];

            double surgeFee;
            if (account instanceof Premium) {
                premiumCount++;
                surgeFee = account.calculateSurgeFee(delay);
            } else {
                regularCount++;
                surgeFee = account.calculateSurgeFee(delay);
            }

            grandTotalSurgeFees += surgeFee;
        }

        if (accounts.length > limit) {
            for (int i = limit; i < accounts.length; i++) {
                if (accounts[i] == null) {
                    nullSkipped++;
                }
            }
        }

        System.out.printf("%d processed | %d null skipped | %d premium | %d regular | grand total surge fees = Rs %.1f%n",
                processed, nullSkipped, premiumCount, regularCount, grandTotalSurgeFees);
    }
}

class Premium extends DeliveryAccount {
    public Premium(String studentId, double orderValue) {
        super(studentId, orderValue);
    }

    public Premium(String studentId) {
        super(studentId, 0.0);
    }
}
