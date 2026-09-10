package oop.assigment_problems;

/**
 * F1. From Procedural Mess to a Working Library Fine System
 * Topic: OOP, Classes and Objects — Week 3 Homework Assignment
 */
class BookIssue {
    private String title;
    private String borrowerName;
    private int daysOverdue;

    public BookIssue(String title, String borrowerName, int daysOverdue) {
        this.title = title;
        this.borrowerName = borrowerName;
        this.daysOverdue = daysOverdue;
    }

    public double fineAmount() {
        return (daysOverdue > 0) ? daysOverdue * 5.0 : 0.0;
    }

    public boolean isSeverelyOverdue() {
        return daysOverdue > 14;
    }

    /*
     * JUSTIFICATION:
     * totalFineCollected is static because computing the total fine across an array of
     * book issues represents a global aggregation utility operation that operates on the
     * collection of issues, belonging to the BookIssue class as a whole rather than any single book.
     * fineAmount is an instance method because the fine calculation depends specifically on the
     * daysOverdue state of a single BookIssue object.
     */
    public static double totalFineCollected(BookIssue[] issues) {
        if (issues == null) return 0.0;
        double total = 0.0;
        for (BookIssue issue : issues) {
            if (issue != null) {
                total += issue.fineAmount();
            }
        }
        return total;
    }

    public String getTitle() {
        return title;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public int getDaysOverdue() {
        return daysOverdue;
    }
}

public class BookIssueFineSystem {
    public static void main(String[] args) {
        BookIssue[] issues = new BookIssue[] {
            new BookIssue("Clean Code", "Borrower1", 18),
            new BookIssue("Effective Java", "Borrower2", 5),
            new BookIssue("Refactoring", "Borrower3", 0),
            new BookIssue("DSA Handbook", "Borrower4", 21),
            new BookIssue("Design Patterns", "Borrower5", 9)
        };

        for (BookIssue issue : issues) {
            String status = issue.isSeverelyOverdue() ? "Severely overdue" : "OK";
            System.out.println(issue.getTitle() + " - " + issue.getDaysOverdue() + " days - " + status);
        }

        double totalFine = BookIssue.totalFineCollected(issues);
        System.out.println("Total fine collected: Rs " + totalFine);
    }
}
