package constructors_and_java_keywords.assigment_problems;

public class Canteen implements Comparable<Canteen> {
    private final String canteenCode;
    private final String canteenName;
    private final int trustScore;

    public Canteen(String canteenCode, String canteenName, int trustScore) {
        if (canteenCode == null || canteenCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Canteen code cannot be null or empty.");
        }
        if (canteenName == null || canteenName.trim().isEmpty()) {
            throw new IllegalArgumentException("Canteen name cannot be null or empty.");
        }
        if (trustScore < 1 || trustScore > 5) {
            throw new IllegalArgumentException("Trust score must be between 1 and 5.");
        }
        this.canteenCode = canteenCode.trim();
        this.canteenName = canteenName.trim();
        this.trustScore = trustScore;
    }

    public Canteen(String canteenCode, String canteenName) {
        this(canteenCode, canteenName, 3); // Defaults to trust score 3
    }

    public String getCanteenCode() {
        return canteenCode;
    }

    public String getCanteenName() {
        return canteenName;
    }

    public int getTrustScore() {
        return trustScore;
    }

    @Override
    public int compareTo(Canteen other) {
        if (other == null) return -1;

        // Rule 1: Trust score descending
        int scoreCompare = Integer.compare(other.trustScore, this.trustScore);
        if (scoreCompare != 0) {
            return scoreCompare;
        }

        // Rule 2: Case-insensitive code comparison
        int codeIgnoreCase = this.canteenCode.compareToIgnoreCase(other.canteenCode);
        if (codeIgnoreCase != 0) {
            return codeIgnoreCase;
        }

        // Rule 3: Case-sensitive code comparison
        int codeCase = this.canteenCode.compareTo(other.canteenCode);
        if (codeCase != 0) {
            return codeCase;
        }

        // Rule 4: Canteen name comparison
        return this.canteenName.compareTo(other.canteenName);
    }

    public static Canteen[] rankCanteens(Canteen[] canteens) {
        if (canteens == null || canteens.length == 0) {
            return new Canteen[0];
        }

        Canteen[] sorted = canteens.clone();

        // Custom stable Insertion Sort implementation
        for (int i = 1; i < sorted.length; i++) {
            Canteen key = sorted[i];
            int j = i - 1;
            while (j >= 0 && sorted[j].compareTo(key) > 0) {
                sorted[j + 1] = sorted[j];
                j = j - 1;
            }
            sorted[j + 1] = key;
        }

        return sorted;
    }

    @Override
    public String toString() {
        return "\"" + canteenCode + "\"";
    }
}
