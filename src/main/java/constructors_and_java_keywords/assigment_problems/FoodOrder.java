package constructors_and_java_keywords.assigment_problems;

public class FoodOrder {
    private final String studentName;
    private final String dishName;
    private boolean isDelivered;

    public FoodOrder(String studentName, String dishName) {
        if (studentName == null || studentName.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be null or whitespace-only.");
        }
        if (dishName == null || dishName.trim().isEmpty()) {
            throw new IllegalArgumentException("Dish name cannot be null or whitespace-only.");
        }
        this.studentName = studentName.trim();
        this.dishName = dishName.trim();
        this.isDelivered = false;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getDishName() {
        return dishName;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void markDelivered() {
        if (this.isDelivered) {
            System.out.printf("WARNING: Order for %s (%s) was already marked delivered!%n", studentName, dishName);
        } else {
            this.isDelivered = true;
            System.out.printf("Order for %s (%s) delivered successfully.%n", studentName, dishName);
        }
    }

    public static void processBatch(String[][] rawOrders) {
        int valid = 0;
        int rejected = 0;

        if (rawOrders != null) {
            for (String[] order : rawOrders) {
                if (order == null || order.length < 2) {
                    rejected++;
                    continue;
                }
                try {
                    new FoodOrder(order[0], order[1]);
                    valid++;
                } catch (IllegalArgumentException e) {
                    rejected++;
                }
            }
        }

        System.out.printf("Valid: %d | Rejected: %d%n", valid, rejected);
    }
}
