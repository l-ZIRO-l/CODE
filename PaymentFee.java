import java.util.Scanner;

interface FeePolicy {
    double feeFor(double value);
}

public class PaymentFee {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        double value = in.nextDouble();

        FeePolicy policy;
        switch (choice) {
            case 1:
                policy = v -> v * 2 / 100;
                break;
            case 2:
                policy = v -> v * 0.5 / 100;
                break;
            default:
                policy = v -> v * 1 / 100;
        }

        double fee = policy.feeFor(value);
        System.out.printf("Payment Amount: %.2f%n", value);
        System.out.printf("Transaction Fee: %.2f%n", fee);
        System.out.printf("Final Amount: %.2f%n", value + fee);
    }
}
