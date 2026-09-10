package constructors_and_java_keywords.class_problems;

public class BusRoute implements Comparable<BusRoute> {
    private final String routeCode;
    private final String routeName;
    private final int priority;

    public BusRoute(String routeCode, String routeName, int priority) {
        if (routeCode == null || routeCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Route code cannot be null or empty.");
        }
        if (routeName == null || routeName.trim().isEmpty()) {
            throw new IllegalArgumentException("Route name cannot be null or empty.");
        }
        this.routeCode = routeCode.trim();
        this.routeName = routeName.trim();
        this.priority = priority;
    }

    public BusRoute(String routeCode, String routeName) {
        this(routeCode, routeName, 1); // Default priority
    }

    public String getRouteCode() {
        return routeCode;
    }

    public String getRouteName() {
        return routeName;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(BusRoute other) {
        if (other == null) return -1;
        // Rule 1: Higher priority comes first
        int priorityCompare = Integer.compare(other.priority, this.priority);
        if (priorityCompare != 0) {
            return priorityCompare;
        }

        // Rule 2: Case-insensitive comparison of route codes
        int codeIgnoreCase = this.routeCode.compareToIgnoreCase(other.routeCode);
        if (codeIgnoreCase != 0) {
            return codeIgnoreCase;
        }

        // Rule 3: Case-sensitive comparison of route codes
        int codeCase = this.routeCode.compareTo(other.routeCode);
        if (codeCase != 0) {
            return codeCase;
        }

        // Rule 4: Route name comparison
        return this.routeName.compareTo(other.routeName);
    }

    public static BusRoute[] rankRoutes(BusRoute[] routes) {
        if (routes == null || routes.length == 0) {
            return new BusRoute[0];
        }

        BusRoute[] sorted = routes.clone();

        // Custom stable Insertion Sort implementation
        for (int i = 1; i < sorted.length; i++) {
            BusRoute key = sorted[i];
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
        return "\"" + routeCode + "\"";
    }
}
