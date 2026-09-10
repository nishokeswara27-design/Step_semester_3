package session1.assigment_problems;

public class MovieReviewWordLengthProfiler {

    /**
     * Profiler that classifies words in a review by length:
     * Short (1-4 letters), Medium (5-8 letters), Long (9+ letters).
     * @param review Movie review string
     */
    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        // Clean punctuation and split by whitespace
        String cleaned = review.replaceAll("[^a-zA-Z0-9\\s]", "");
        String[] words = cleaned.trim().split("\\s+");

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            int len = word.length();
            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else if (len >= 9) {
                longCount++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortCount, mediumCount, longCount);
    }

    public static void main(String[] args) {
        String review = "This movie was absolutely fantastic and thrilling";
        System.out.printf("Input: \"%s\"%n", review);
        classifyWordLengths(review);
    }
}
