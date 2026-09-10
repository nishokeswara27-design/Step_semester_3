package string.class_problems;

public class FileExtensionValidator {

    public static String validateFileExtension(String filename) {
        if (filename == null) {
            String msg = "Rejected — invalid file type";
            System.out.println(msg);
            return msg;
        }

        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) {
            String msg = "Rejected — invalid file type";
            System.out.println(msg);
            return msg;
        }

        String extension = filename.substring(lastDotIndex + 1);
        if (extension.equalsIgnoreCase("pdf") || 
            extension.equalsIgnoreCase("docx") || 
            extension.equalsIgnoreCase("zip")) {
            String msg = "Accepted";
            System.out.println(msg);
            return msg;
        } else {
            String msg = "Rejected — invalid file type";
            System.out.println(msg);
            return msg;
        }
    }

    public static void main(String[] args) {
        validateFileExtension("Assignment1.PDF");
        validateFileExtension("notes.txt");
    }
}
