import java.util.Scanner;

class Program {
    private final String category;
    private final double price;
    private final double percentOff;

    Program(String category, double price, double percentOff) {
        this.category = category;
        this.price = price;
        this.percentOff = percentOff;
    }

    String getCategory() {
        return category;
    }

    double getDiscount() {
        return price * percentOff / 100;
    }

    double getPayable() {
        return price - getDiscount();
    }
}

public class CourseBilling {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        double price = in.nextDouble();

        Program p;
        switch (choice) {
            case 1:
                p = new Program("Programming", price, 10);
                break;
            case 2:
                p = new Program("Data Science", price, 15);
                break;
            default:
                p = new Program("Cloud", price, 5);
        }

        System.out.println("Course Type: " + p.getCategory());
        System.out.printf("Discount: %.2f%n", p.getDiscount());
        System.out.printf("Final Fee: %.2f%n", p.getPayable());
    }
}
