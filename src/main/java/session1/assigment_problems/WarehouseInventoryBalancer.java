package session1.assigment_problems;

public class WarehouseInventoryBalancer {

    /**
     * Analyzes warehouse inventory across Section A and Section B.
     * @param sectionA Item quantities in Section A
     * @param sectionB Item quantities in Section B
     */
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null || sectionA.length != sectionB.length) {
            System.out.println("Invalid section inventory data.");
            return;
        }

        int totalA = 0;
        int totalB = 0;

        for (int qty : sectionA) {
            totalA += qty;
        }
        for (int qty : sectionB) {
            totalB += qty;
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        int maxQuantity = Integer.MIN_VALUE;
        String maxSection = "";
        int maxIndex = -1;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > maxQuantity) {
                maxQuantity = sectionA[i];
                maxSection = "Section A";
                maxIndex = i + 1; // 1-indexed item
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > maxQuantity) {
                maxQuantity = sectionB[i];
                maxSection = "Section B";
                maxIndex = i + 1; // 1-indexed item
            }
        }

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                totalA, totalB, status, maxQuantity, maxSection, maxIndex);
    }

    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        analyzeInventory(sectionA, sectionB);
    }
}
