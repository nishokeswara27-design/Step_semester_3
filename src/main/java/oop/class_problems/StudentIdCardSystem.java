package oop.class_problems;

/**
 * F4. Designing the Instance/Static Boundary for a College-Wide System
 * Topic: Instance vs Static Design Decisions
 */

// Broken draft reproducing the static misuse bug
class BrokenSrmStudent {
    static String name;
    static String regNo;
    static int attendance;

    public BrokenSrmStudent(String name, String regNo, int attendance) {
        BrokenSrmStudent.name = name;
        BrokenSrmStudent.regNo = regNo;
        BrokenSrmStudent.attendance = attendance;
    }

    public void printName() {
        System.out.println(name);
    }
}

// Fixed class design
class FixedSrmStudent {
    private String name;
    private String regNo;
    private int attendance;

    private static String university = "SRM";
    private static int admissionCount = 0;

    /*
     * EXPLANATION:
     * Marking name, regNo, and attendance as static in the broken version was wrong because:
     * 1. 'name' is unique to each individual student. Making it static shares one single
     *    name variable across all instances, overwriting previous students' names.
     * 2. 'regNo' uniquely identifies a specific student. Making it static overwrites the ID
     *    for all existing instances whenever a new student registers.
     * 3. 'attendance' represents an individual's attendance percentage, not a shared value.
     * On the other hand, 'university' and 'admissionCount' are static because they belong to
     * the institution as a whole across all student records.
     */

    public FixedSrmStudent(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        admissionCount++;
        this.regNo = "RA2311003010" + (10 + admissionCount);
    }

    public void printIdCard() {
        System.out.println(name + " | " + regNo);
    }

    public static void printTotalAdmissions() {
        System.out.println("Students admitted so far: " + admissionCount);
    }

    public String getName() {
        return name;
    }
}

public class StudentIdCardSystem {
    public static void main(String[] args) {
        System.out.println("Broken version:");
        BrokenSrmStudent b1 = new BrokenSrmStudent("Ravi", "RA001", 80);
        BrokenSrmStudent b2 = new BrokenSrmStudent("Meera", "RA002", 90);
        b1.printName();
        b2.printName();

        System.out.println("\nFixed version: same two students created");
        FixedSrmStudent f1 = new FixedSrmStudent("Ravi", 80);
        FixedSrmStudent f2 = new FixedSrmStudent("Meera", 90);

        f1.printIdCard();
        f2.printIdCard();
        FixedSrmStudent.printTotalAdmissions();
    }
}
