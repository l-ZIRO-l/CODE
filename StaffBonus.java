import java.util.Scanner;

class Worker {
    protected final String name;

    Worker(String name) {
        this.name = name;
    }

    double bonus() {
        return 0;
    }

    // overloaded version: bonus calculated from a given amount
    double bonus(double amount) {
        return 0;
    }
}

class TechWorker extends Worker {
    private final double salary;
    private final int rating;

    TechWorker(String name, double salary, int rating) {
        super(name);
        this.salary = salary;
        this.rating = rating;
    }

    @Override
    double bonus() {
        return bonus(salary, rating);
    }

    // overloaded version with two parameters
    double bonus(double pay, int score) {
        return pay * score * 2 / 100;
    }

    double baseEarning() {
        return salary;
    }
}

class SalesWorker extends Worker {
    private final double sales;

    SalesWorker(String name, double sales) {
        super(name);
        this.sales = sales;
    }

    @Override
    double bonus() {
        return bonus(sales);
    }

    @Override
    double bonus(double amount) {
        return amount * 3 / 100;
    }

    double baseEarning() {
        return sales;
    }
}

public class StaffBonus {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        String name = in.next();
        double amount = in.nextDouble();

        Worker w;
        double base;
        if (choice == 1) {
            int rating = in.nextInt();
            TechWorker t = new TechWorker(name, amount, rating);
            base = t.baseEarning();
            w = t;
        } else {
            SalesWorker s = new SalesWorker(name, amount);
            base = s.baseEarning();
            w = s;
        }

        double bonus = w.bonus();
        System.out.println("Employee Name: " + w.name);
        System.out.printf("Bonus: %.2f%n", bonus);
        System.out.printf("Total Earnings: %.2f%n", base + bonus);
    }
}
