package oop.assigment_problems;

/**
 * F4. Designing the Instance/Static Boundary for a Library Membership System
 * Topic: Instance vs static design decisions, constructors, static misuse bug debugging
 */

// Broken version demonstrating static misuse bug
class BrokenLibraryMember {
    static String name;
    static String memberId;
    static int booksIssued;

    public BrokenLibraryMember(String name, String memberId, int booksIssued) {
        BrokenLibraryMember.name = name;
        BrokenLibraryMember.memberId = memberId;
        BrokenLibraryMember.booksIssued = booksIssued;
    }

    public void printName() {
        System.out.println(name);
    }
}

// Redesigned fixed class with proper instance/static split
class FixedLibraryMember {
    private String name;
    private String memberId;
    private int booksIssued;

    private static String libraryName = "City Central Library";
    private static int memberCount = 0;

    /*
     * EXPLANATION FOR STATIC FIELD MISUSE:
     * 1. 'name': Each member has a distinct name. Marking it static causes all member instances
     *    to share a single name variable, overwriting previous members' names whenever a new instance is created.
     * 2. 'memberId': Member ID must uniquely identify a specific library member. Making it static
     *    overwrites the ID for all members across the system.
     * 3. 'booksIssued': Represents the count of books issued to a specific person. Making it static
     *    mixes up borrowing counts among different members.
     * 
     * In contrast, 'libraryName' is shared across all members of the library, and 'memberCount'
     * tracks total membership institution-wide, so both of those are correctly marked static.
     */

    public FixedLibraryMember(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
        memberCount++;
        this.memberId = "LM-" + (1000 + memberCount);
    }

    public void printMemberCard() {
        System.out.println(name + " | " + memberId);
    }

    public static void printTotalMembers() {
        System.out.println("Total members: " + memberCount);
    }
}

public class LibraryMembershipSystem {
    public static void main(String[] args) {
        System.out.println("Broken version:");
        BrokenLibraryMember b1 = new BrokenLibraryMember("Aditi", "LM-1001", 2);
        BrokenLibraryMember b2 = new BrokenLibraryMember("Rohan", "LM-1002", 5);
        b1.printName();
        b2.printName();

        System.out.println("\nFixed version: same two members created");
        FixedLibraryMember f1 = new FixedLibraryMember("Aditi", 2);
        FixedLibraryMember f2 = new FixedLibraryMember("Rohan", 5);

        f1.printMemberCard();
        f2.printMemberCard();
        FixedLibraryMember.printTotalMembers();
    }
}
