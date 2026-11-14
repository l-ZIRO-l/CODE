import java.util.Scanner;

abstract class StaffMember {
    private final String role;
    private final int level;

    StaffMember(String role, int level) {
        this.role = role;
        this.level = level;
    }

    String getRole() {
        return role;
    }

    int getLevel() {
        return level;
    }

    boolean isAllowed(int needed) {
        return level >= needed;
    }
}

class Programmer extends StaffMember {
    Programmer() {
        super("Developer", 1);
    }
}

class TeamLead extends StaffMember {
    TeamLead() {
        super("Manager", 2);
    }
}

class SystemAdmin extends StaffMember {
    SystemAdmin() {
        super("Administrator", 3);
    }
}

public class StaffAccess {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        int needed = in.nextInt();

        StaffMember member;
        switch (choice) {
            case 1:
                member = new Programmer();
                break;
            case 2:
                member = new TeamLead();
                break;
            default:
                member = new SystemAdmin();
        }

        System.out.println("Role: " + member.getRole());
        System.out.println("Access Level: " + member.getLevel());
        System.out.println("Can Access: " + member.isAllowed(needed));
    }
}
