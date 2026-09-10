package oop.class_problems;

/**
 * F5. Capstone: A Small Fee + Hostel Management Mini-System
 * Topic: Composition, Encapsulation, Inheritance, Null-Safe handling, Static counters
 */
class SrmStudentRecord {
    private String name;
    private String regNo;
    private HostelFeeAccount feeAccount;
    private HostelRoom room;

    public static int totalStudents = 0;

    public SrmStudentRecord(String name, String regNo, HostelFeeAccount feeAccount, HostelRoom room) {
        this.name = name;
        this.regNo = regNo;
        this.feeAccount = feeAccount;
        this.room = room;
        totalStudents++;
    }

    public String fullStatus() {
        double due = (feeAccount != null) ? feeAccount.getDue() : 0.0;
        String roomStr = (room != null) ? "Room: " + room.getRoomNo() : "Room: unallotted";
        return name + " | Due: Rs " + due + " | " + roomStr;
    }

    public String getName() {
        return name;
    }

    public HostelFeeAccount getFeeAccount() {
        return feeAccount;
    }

    public HostelRoom getRoom() {
        return room;
    }
}

public class FeeHostelMiniSystem {
    public static void main(String[] args) {
        HostelRoom room1 = new HostelRoom("C-214", 3, 2);
        HostelRoom room2 = new HostelRoom("C-507", 2, 1);

        HostelFeeAccount fee1 = new HostelFeeAccount("RA231100301011", 200000, 60000);
        HostelFeeAccount fee2 = new HostelFeeAccount("RA231100301012", 200000, 20000);
        HostelFeeAccount fee3 = new HostelFeeAccount("RA231100301013", 200000, 0);

        room1.allot("Ravi");
        room2.allot("Anitha");

        // Processing a rejected payment (negative amount)
        fee3.pay(-5000);

        SrmStudentRecord s1 = new SrmStudentRecord("Ravi", "RA231100301011", fee1, room1);
        SrmStudentRecord s2 = new SrmStudentRecord("Anitha", "RA231100301012", fee2, room2);
        SrmStudentRecord s3 = new SrmStudentRecord("Karthik", "RA231100301013", fee3, null);

        System.out.println(s1.fullStatus());
        System.out.println(s2.fullStatus());
        System.out.println(s3.fullStatus());
        System.out.println("Total students: " + SrmStudentRecord.totalStudents);
    }
}
