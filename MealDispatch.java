import java.util.Scanner;

abstract class Dispatch {
    protected final double bill;

    Dispatch(double bill) {
        this.bill = bill;
    }

    abstract double totalCost();
}

class StandardDispatch extends Dispatch {
    StandardDispatch(double bill) {
        super(bill);
    }

    double totalCost() {
        return bill + 40.0;
    }
}

class FastDispatch extends Dispatch {
    FastDispatch(double bill) {
        super(bill);
    }

    double totalCost() {
        return bill + 80.0 + (bill * 5 / 100);
    }
}

public class MealDispatch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        double bill = in.nextDouble();

        Dispatch d;
        switch (choice) {
            case 1:
                d = new StandardDispatch(bill);
                break;
            default:
                d = new FastDispatch(bill);
        }

        System.out.printf("%.2f%n", d.totalCost());
    }
}
