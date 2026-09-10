package oop.class_problems;

/**
 * F3. Object References, Null Safety, and a Mutating Method
 * Topic: Null Safety, Object References vs Copies
 */
class HostelRoom {
    private String roomNo;
    private int beds;
    private int occupied;

    public HostelRoom(String roomNo, int beds, int occupied) {
        this.roomNo = roomNo;
        this.beds = beds;
        this.occupied = occupied;
    }

    public boolean allot(String studentName) {
        if (occupied < beds) {
            occupied++;
            return true;
        }
        return false;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public int getBeds() {
        return beds;
    }

    public int getOccupied() {
        return occupied;
    }

    public boolean isFull() {
        return occupied >= beds;
    }
}

public class HostelRoomAllocation {

    public static HostelRoom findAvailableRoom(HostelRoom[] rooms) {
        if (rooms == null) return null;
        for (HostelRoom room : rooms) {
            if (room != null && !room.isFull()) {
                return room;
            }
        }
        return null;
    }

    public static void safeAllot(HostelRoom[] rooms, String studentName) {
        HostelRoom availableRoom = findAvailableRoom(rooms);
        if (availableRoom == null) {
            System.out.println("No rooms available for " + studentName);
        } else {
            availableRoom.allot(studentName);
            System.out.println(studentName + " allotted to room " + availableRoom.getRoomNo());
        }
    }

    /*
     * JUSTIFICATION / EXPLANATION:
     * Passing the HostelRoom array into findAvailableRoom or safeAllot passes the array
     * reference by value. In Java, objects and arrays reside on the heap, and the array
     * stores references pointing to those HostelRoom objects. The methods receive a copy
     * of the reference, not copies of the HostelRoom instances. Any mutation (such as
     * calling allot() which increments occupied) mutates the original object on the heap.
     */

    public static void main(String[] args) {
        HostelRoom[] batch1 = new HostelRoom[] {
            new HostelRoom("C-214", 3, 2),
            new HostelRoom("C-507", 2, 2)
        };
        safeAllot(batch1, "Divya");

        HostelRoom[] batch2 = new HostelRoom[] {
            new HostelRoom("C-214", 3, 3),
            new HostelRoom("C-507", 2, 2)
        };
        safeAllot(batch2, "Divya");
    }
}
