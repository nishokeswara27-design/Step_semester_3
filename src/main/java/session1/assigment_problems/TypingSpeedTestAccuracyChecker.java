package session1.assigment_problems;

public class TypingSpeedTestAccuracyChecker {

    /**
     * Compares original text vs typed text character-by-character to report accuracy and first mismatch.
     * @param original Original passage string
     * @param typed    User's typed text string
     */
    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input strings.");
            return;
        }

        int totalChars = original.length();
        int matchedChars = 0;
        int firstMismatchPos = -1;
        char origMismatchChar = '\0';
        char typedMismatchChar = '\0';

        int minLen = Math.min(original.length(), typed.length());

        for (int i = 0; i < minLen; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedChars++;
            } else {
                if (firstMismatchPos == -1) {
                    firstMismatchPos = i + 1; // 1-indexed position
                    origMismatchChar = original.charAt(i);
                    typedMismatchChar = typed.charAt(i);
                }
            }
        }

        double accuracy = ((double) matchedChars / totalChars) * 100.0;

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Matched: %d/%d | Accuracy: %.2f%% | ", matchedChars, totalChars, accuracy));

        if (firstMismatchPos != -1) {
            sb.append(String.format("First Mismatch at position %d ('%c' vs '%c')",
                    firstMismatchPos, origMismatchChar, typedMismatchChar));
        } else {
            sb.append("No Mismatches");
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1:");
        checkTypingAccuracy("hello world", "hello worlt");

        System.out.println("\nTest Case 2:");
        checkTypingAccuracy("coding", "coding");
    }
}
