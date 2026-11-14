import java.util.Scanner;

class Item {
    final int code;
    final String label;
    final double cost;
    private final double offerPercent;

    Item(int code, String label, double cost, double offerPercent) {
        this.code = code;
        this.label = label;
        this.cost = cost;
        this.offerPercent = offerPercent;
    }

    double offer() {
        return cost * offerPercent / 100;
    }
}

public class ItemPricing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        int code = in.nextInt();
        String label = in.next();
        double cost = in.nextDouble();

        double percent;
        switch (choice) {
            case 1:
                percent = 12;
                break;
            case 2:
                percent = 20;
                break;
            default:
                percent = 5;
        }

        Item item = new Item(code, label, cost, percent);
        double offer = item.offer();

        System.out.println("Product ID: " + item.code);
        System.out.println("Product Name: " + item.label);
        System.out.printf("Discount: %.2f%n", offer);
        System.out.printf("Final Price: %.2f%n", item.cost - offer);
    }
}
