package session1.class_problems;

public class PalindromeChecker {

    /**
     * Checks if a string is a palindrome using an iterative approach (two-pointer).
     */
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Checks if a string is a palindrome using recursion.
     */
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        return isPalindromeRecursiveHelper(text, 0, text.length() - 1);
    }

    private static boolean isPalindromeRecursiveHelper(String text, int left, int right) {
        if (left >= right) return true;
        if (text.charAt(left) != text.charAt(right)) return false;
        return isPalindromeRecursiveHelper(text, left + 1, right - 1);
    }

    /**
     * Checks if a string is a palindrome by array reversal.
     */
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        return new String(reversed).equals(text);
    }

    public static void testAndPrint(String input) {
        boolean iterative = isPalindromeIterative(input);
        boolean recursive = isPalindromeRecursive(input);
        boolean reversal = isPalindromeArrayReversal(input);

        String iterStr = iterative ? "Palindrome" : "Not Palindrome";
        String recStr = recursive ? "Palindrome" : "Not Palindrome";
        String revStr = reversal ? "Palindrome" : "Not Palindrome";

        System.out.printf("Input: \"%s\"%n", input);
        System.out.printf("Iterative: %s | Recursive: %s | Array Reversal: %s%n%n", iterStr, recStr, revStr);
    }

    public static void main(String[] args) {
        testAndPrint("madam");
        testAndPrint("hello");
    }
}
