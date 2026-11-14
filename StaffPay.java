import java.util.Scanner;

abstract class Person {
    private final int id;
    private final String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    abstract double pay();
}

class PermanentStaff extends Person {
    private final double monthly;

    PermanentStaff(int id, String name, double monthly) {
        super(id, name);
        this.monthly = monthly;
    }

    double pay() {
        return monthly;
    }
}

class ContractStaff extends Person {
    private final int days;
    private final double perDay;

    ContractStaff(int id, String name, int days, double perDay) {
        super(id, name);
        this.days = days;
        this.perDay = perDay;
    }

    double pay() {
        return days * perDay;
    }
}

public class StaffPay {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        int id = in.nextInt();
        String name = in.next();

        Person p;
        if (choice == 1) {
            p = new PermanentStaff(id, name, in.nextDouble());
        } else {
            int days = in.nextInt();
            double perDay = in.nextDouble();
            p = new ContractStaff(id, name, days, perDay);
        }

        System.out.println("Employee ID: " + p.getId());
        System.out.println("Employee Name: " + p.getName());
        System.out.printf("Salary: %.2f%n", p.pay());
    }
}
