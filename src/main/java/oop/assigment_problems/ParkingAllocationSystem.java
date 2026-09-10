package oop.assigment_problems;

/**
 * F3. Object References, Null Safety, and a Mutating Method
 * Topic: Object References, Null Handling, Avoiding NullPointerException
 */
class ParkingSlot {
    private String slotNo;
    private int capacity;
    private int occupiedCount;

    public ParkingSlot(String slotNo, int capacity, int occupiedCount) {
        this.slotNo = slotNo;
        this.capacity = capacity;
        this.occupiedCount = occupiedCount;
    }

    public boolean allot(String vehicleNo) {
        if (occupiedCount < capacity) {
            occupiedCount++;
            return true;
        }
        return false;
    }

    public String getSlotNo() {
        return slotNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getOccupiedCount() {
        return occupiedCount;
    }

    public boolean isFull() {
        return occupiedCount >= capacity;
    }
}

public class ParkingAllocationSystem {

    public static ParkingSlot findAvailableSlot(ParkingSlot[] slots) {
        if (slots == null) return null;
        for (ParkingSlot slot : slots) {
            if (slot != null && !slot.isFull()) {
                return slot;
            }
        }
        return null;
    }

    public static void safeAllot(ParkingSlot[] slots, String vehicleNo) {
        ParkingSlot availableSlot = findAvailableSlot(slots);
        if (availableSlot == null) {
            System.out.println("No slots available for " + vehicleNo);
        } else {
            availableSlot.allot(vehicleNo);
            System.out.println(vehicleNo + " allotted to slot " + availableSlot.getSlotNo());
        }
    }

    /*
     * EXPLANATION:
     * Passing the ParkingSlot array into findAvailableSlot and safeAllot passes the array
     * reference by value. Arrays in Java are object references pointing to elements in heap memory.
     * Passing the array does not copy the ParkingSlot objects inside it. Both the calling method
     * and safeAllot access the exact same ParkingSlot objects on the heap, allowing state mutations
     * (incrementing occupiedCount) to persist directly.
     */

    public static void main(String[] args) {
        // Run 1: Array with an available slot (A1 has 3/4)
        ParkingSlot[] slots1 = new ParkingSlot[] {
            new ParkingSlot("A1", 4, 3),
            new ParkingSlot("A2", 5, 5)
        };
        safeAllot(slots1, "TN09AB1234");

        // Run 2: Array where all slots are full (A1 has 4/4)
        ParkingSlot[] slots2 = new ParkingSlot[] {
            new ParkingSlot("A1", 4, 4),
            new ParkingSlot("A2", 5, 5)
        };
        safeAllot(slots2, "TN09AB1234");
    }
}
