package string.class_problems;

public class BankTransactionReferenceValidator {

    public static String normalizeReference(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            String msg = "Invalid: wrong length";
            System.out.println(msg);
            return msg;
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                String msg = "Invalid: bank code must be 3 letters";
                System.out.println(msg);
                return msg;
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                String msg = "Invalid: non-digit body";
                System.out.println(msg);
                return msg;
            }
        }

        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String seq = reference.substring(9, 14);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] ");
        sb.append("DATE: ").append(day).append("/").append(month).append("/").append(year).append(" | ");
        sb.append("SEQ: ").append(seq);

        String result = sb.toString();
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        String ref1 = normalizeReference(" hdf03022600042 ");
        validateAndFormat(ref1);

        String ref2 = normalizeReference("12F03022600042");
        validateAndFormat(ref2);
    }
}
