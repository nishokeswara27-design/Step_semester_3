package oop.assigment_problems;

/**
 * F5. Capstone: A Small HR + Parking Allocation Mini-System
 * Topic: Composition, Encapsulation, Inheritance, Null-Safe handling, Static counters
 */
class CompanyEmployeeRecord {
    private String name;
    private String empId;
    private Employee employee;
    private ParkingSlot slot;

    public static int totalRecords = 0;

    public CompanyEmployeeRecord(String name, String empId, Employee employee, ParkingSlot slot) {
        this.name = name;
        this.empId = empId;
        this.employee = employee;
        this.slot = slot;
        totalRecords++;
    }

    public String fullProfile() {
        double pay = 0.0;
        if (employee instanceof ManagerEmployee) {
            pay = ((ManagerEmployee) employee).effectiveSalary();
        } else if (employee instanceof InternEmployee) {
            pay = ((InternEmployee) employee).effectiveSalary();
        } else if (employee != null) {
            pay = employee.getSalary();
        }

        String slotStr = (slot != null) ? slot.getSlotNo() : "no parking assigned";
        return name + " | Pay: Rs " + pay + " | Slot: " + slotStr;
    }

    public String getName() {
        return name;
    }

    public String getEmpId() {
        return empId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public ParkingSlot getSlot() {
        return slot;
    }
}

public class HrParkingMiniSystem {
    public static void main(String[] args) {
        ParkingSlot slotA1 = new ParkingSlot("A1", 4, 3);
        ParkingSlot slotA2 = new ParkingSlot("A2", 5, 4);

        ManagerEmployee divyaEmp = new ManagerEmployee("E101", "Divya", 70000.0, 8000.0);
        Employee karanEmp = new Employee("E102", "Karan", 40000.0);
        InternEmployee meeraEmp = new InternEmployee("E103", "Meera", 12000.0, 10000.0);

        slotA1.allot("DivyaVehicle");
        slotA2.allot("KaranVehicle");

        CompanyEmployeeRecord r1 = new CompanyEmployeeRecord("Divya", "E101", divyaEmp, slotA1);
        CompanyEmployeeRecord r2 = new CompanyEmployeeRecord("Karan", "E102", karanEmp, slotA2);
        CompanyEmployeeRecord r3 = new CompanyEmployeeRecord("Meera", "E103", meeraEmp, null);

        System.out.println(r1.fullProfile());
        System.out.println(r2.fullProfile());
        System.out.println(r3.fullProfile());
        System.out.println("Total records: " + CompanyEmployeeRecord.totalRecords);
    }
}
