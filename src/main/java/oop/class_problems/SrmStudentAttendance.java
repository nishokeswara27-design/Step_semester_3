package oop.class_problems;

/**
 * F1. From Procedural Mess to a Working Attendance System
 * Topic: OOP, Classes and Objects — Week 3 (Practice Problems)
 */
class SrmStudent {
    private String name;
    private String regNo;
    private int attendance;

    public SrmStudent(String name, String regNo, int attendance) {
        this.name = name;
        this.regNo = regNo;
        this.attendance = attendance;
    }

    public void addAttendanceUpdate(int newAttendance) {
        this.attendance = newAttendance;
    }

    public boolean isEligible() {
        return this.attendance >= 75;
    }

    /*
     * JUSTIFICATION:
     * classAverage is declared static because calculating the average attendance
     * across an array of students is a class-level utility operation. It does not
     * depend on the instance state of any single student.
     * In contrast, isEligible() is an instance method because eligibility depends directly
     * on the individual attendance percentage of a specific SrmStudent object.
     */
    public static double classAverage(SrmStudent[] students) {
        if (students == null || students.length == 0) {
            return 0.0;
        }
        double sum = 0;
        for (SrmStudent s : students) {
            sum += s.attendance;
        }
        return sum / students.length;
    }

    public String getName() {
        return name;
    }

    public String getRegNo() {
        return regNo;
    }

    public int getAttendance() {
        return attendance;
    }
}

public class SrmStudentAttendance {
    public static void main(String[] args) {
        SrmStudent[] students = new SrmStudent[] {
            new SrmStudent("Ravi", "REG101", 82),
            new SrmStudent("Anitha", "REG102", 68),
            new SrmStudent("Karthik", "REG103", 91),
            new SrmStudent("Meera", "REG104", 74),
            new SrmStudent("Suresh", "REG105", 60)
        };

        for (SrmStudent s : students) {
            String status = s.isEligible() ? "Eligible" : "Detained";
            System.out.println(s.getName() + " - " + s.getAttendance() + "% - " + status);
        }

        double avg = SrmStudent.classAverage(students);
        System.out.printf("Class average: %.1f%%\n", avg);
    }
}
