package oop.class_problems;

/**
 * F2. Extending FeeAccount Without Touching It
 * Topic: Inheritance, Encapsulation, Extensibility
 */
class FeeAccount {
    private String regNo;
    private double totalFee;
    private double amountPaid;

    public FeeAccount(String regNo, double totalFee, double amountPaid) {
        this.regNo = regNo;
        this.totalFee = totalFee;
        this.amountPaid = amountPaid;
    }

    public void pay(double amount) {
        if (amount <= 0) {
            System.out.println("Payment rejected: Amount must be positive.");
            return;
        }
        this.amountPaid += amount;
    }

    public double getDue() {
        return Math.max(0, totalFee - amountPaid);
    }

    public String getRegNo() {
        return regNo;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public double getAmountPaid() {
        return amountPaid;
    }
}

class HostelFeeAccount extends FeeAccount {
    public HostelFeeAccount(String regNo, double totalFee, double amountPaid) {
        super(regNo, totalFee, amountPaid);
    }

    public void payInTwoInstallments(double amount) {
        if (amount <= 0) {
            System.out.println("Payment rejected: Amount must be positive.");
            return;
        }
        double installment = amount / 2.0;
        pay(installment);
        pay(installment);
    }
}

class ScholarshipFeeAccount extends FeeAccount {
    private double scholarshipPercent;

    public ScholarshipFeeAccount(String regNo, double totalFee, double amountPaid, double scholarshipPercent) {
        super(regNo, totalFee, amountPaid);
        this.scholarshipPercent = scholarshipPercent;
    }

    public double effectiveDue() {
        double currentDue = getDue();
        return currentDue * (1.0 - (scholarshipPercent / 100.0));
    }

    public double getScholarshipPercent() {
        return scholarshipPercent;
    }
}

public class FeeAccountManagement {
    public static void main(String[] args) {
        FeeAccount plain = new FeeAccount("REG001", 150000, 150000);
        HostelFeeAccount hostel = new HostelFeeAccount("REG002", 200000, 60000);
        ScholarshipFeeAccount scholarship = new ScholarshipFeeAccount("REG003", 180000, 0, 20);

        FeeAccount[] accounts = new FeeAccount[] { plain, hostel, scholarship };

        for (FeeAccount acc : accounts) {
            if (acc instanceof ScholarshipFeeAccount) {
                ScholarshipFeeAccount s = (ScholarshipFeeAccount) acc;
                System.out.println("Scholarship account effective due: Rs " + s.effectiveDue());
            } else if (acc instanceof HostelFeeAccount) {
                HostelFeeAccount h = (HostelFeeAccount) acc;
                System.out.println("Hostel account due: Rs " + h.getDue());
            } else {
                System.out.println("Plain account due: Rs " + acc.getDue());
            }
        }
    }
}
