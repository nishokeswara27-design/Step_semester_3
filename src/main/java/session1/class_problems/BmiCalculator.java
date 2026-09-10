package session1.class_problems;

public class BmiCalculator {

    /**
     * Returns the BMI health status classification based on standard ranges.
     */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    /**
     * Calculates BMI for each team member and prints a formatted tabular wellness report.
     */
    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            System.out.println("Invalid input arrays.");
            return;
        }

        System.out.println("Person | Height (m) | Weight (kg) | BMI   | Status");
        System.out.println("-----------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double height = heights[i];
            double weight = weights[i];
            double bmi = weight / (height * height);
            String status = getBmiStatus(bmi);

            System.out.printf("Person %d — Height: %.2f m, Weight: %.2f kg | BMI: %.2f | Status: %s%n",
                    (i + 1), height, weight, bmi, status);
        }
    }

    public static void main(String[] args) {
        double[] heights = {1.75, 1.60, 1.80, 1.65, 1.70};
        double[] weights = {70.0, 90.0, 65.0, 85.0, 48.0};

        printWellnessReport(heights, weights);
    }
}
