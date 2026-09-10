package constructors_and_java_keywords.assigment_problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DeliverySlot {
    private static final String DEFAULT_SLOT = "ASAP";
    private static final Set<String> PEAK_HOURS = new HashSet<>(Arrays.asList(
            "12:00-13:00",
            "13:00-14:00",
            "19:00-20:00",
            "20:00-21:00"
    ));

    private final String orderId;
    private final String timeSlot;

    public DeliverySlot(String orderId, String timeSlot) {
        if (orderId == null || orderId.trim().isEmpty()) {
            throw new IllegalArgumentException("Order ID cannot be null or empty.");
        }
        if (timeSlot == null || timeSlot.trim().isEmpty()) {
            throw new IllegalArgumentException("Time slot cannot be null or empty.");
        }
        this.orderId = orderId.trim();
        this.timeSlot = timeSlot.trim();
    }

    public DeliverySlot(String orderId) {
        this(orderId, DEFAULT_SLOT);
    }

    public String getOrderId() {
        return orderId;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public boolean isPeakHour() {
        return PEAK_HOURS.contains(timeSlot);
    }
}
