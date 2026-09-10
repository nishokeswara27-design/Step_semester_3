package session1.class_problems;

public class FirstNonRepeatingCharacter {

    /**
     * Finds and returns the first non-repeating character in the given text string.
     * Returns '\0' if no non-repeating character exists.
     */
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256) {
                frequency[ch]++;
            }
        }

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256 && frequency[ch] == 1) {
                return ch;
            }
        }

        return '\0';
    }

    public static void test(String text) {
        char result = findFirstNonRepeatingChar(text);
        System.out.printf("Input: \"%s\"%n", text);
        if (result != '\0') {
            System.out.printf("First Non-Repeating Character: '%c'%n%n", result);
        } else {
            System.out.println("No Non-Repeating Character Found\n");
        }
    }

    public static void main(String[] args) {
        test("swiss");
        test("aabbcc");
    }
}
