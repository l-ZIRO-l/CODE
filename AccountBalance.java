import java.util.Scanner;

abstract class Holder {
    protected final int number;
    protected final double funds;

    Holder(int number, double funds) {
        this.number = number;
        this.funds = funds;
    }

    abstract double closingBalance();
}

class SavingsHolder extends Holder {
    private final double ratePercent;

    SavingsHolder(int number, double funds, double ratePercent) {
        super(number, funds);
        this.ratePercent = ratePercent;
    }

    double closingBalance() {
        return funds + (funds * ratePercent / 100);
    }
}

class CurrentHolder extends Holder {
    private final double overdraft;

    CurrentHolder(int number, double funds, double overdraft) {
        super(number, funds);
        this.overdraft = overdraft;
    }

    double closingBalance() {
        return funds + overdraft;
    }
}

public class AccountBalance {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        int number = in.nextInt();
        double funds = in.nextDouble();
        double extra = in.nextDouble();

        Holder h;
        switch (choice) {
            case 1:
                h = new SavingsHolder(number, funds, extra);
                break;
            default:
                h = new CurrentHolder(number, funds, extra);
        }

        System.out.printf("%.2f%n", h.closingBalance());
    }
}
