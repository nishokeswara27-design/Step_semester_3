package string.class_problems;

public class MaskedPhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            String msg = "Invalid phone number";
            System.out.println(msg);
            return msg;
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                String msg = "Invalid phone number";
                System.out.println(msg);
                return msg;
            }
        }

        StringBuilder sb = new StringBuilder("XXXXXX");
        sb.append("-");
        sb.append(phone.substring(6));

        String result = sb.toString();
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        maskPhoneNumber("9876543210");
        maskPhoneNumber("98765");
    }
}
