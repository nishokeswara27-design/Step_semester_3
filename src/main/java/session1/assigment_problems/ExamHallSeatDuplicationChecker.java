package session1.assigment_problems;

public class ExamHallSeatDuplicationChecker {

    /**
     * Checks for duplicate seat numbers using primitive arrays and nested loops.
     * @param seatNumbers Array of seat numbers assigned to students
     */
    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("No seat numbers provided.");
            return;
        }

        boolean foundDuplicate = false;
        boolean[] reported = new boolean[seatNumbers.length];

        for (int i = 0; i < seatNumbers.length; i++) {
            if (reported[i]) continue;
            boolean isDup = false;
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    isDup = true;
                    reported[j] = true;
                }
            }
            if (isDup) {
                foundDuplicate = true;
                System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
            }
        }

        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        int[] input1 = {101, 102, 103, 102, 105};
        System.out.println("Test Case 1:");
        checkDuplicateSeats(input1);

        System.out.println();

        int[] input2 = {101, 102, 103, 104, 105};
        System.out.println("Test Case 2:");
        checkDuplicateSeats(input2);
    }
}
