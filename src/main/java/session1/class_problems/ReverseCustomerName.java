package session1.class_problems;

public class ReverseCustomerName {

    /**
     * Reverses the customer's name without modifying the original data.
     * @param customerName The original customer name string
     * @return The reversed customer name string
     */
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }

        char[] chars = customerName.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String name = "Sunil";
        String reversed = reverseCustomerName(name);

        System.out.printf("Original Name: %s%n", name);
        System.out.printf("Reversed Name: %s%n", reversed);
    }
}
