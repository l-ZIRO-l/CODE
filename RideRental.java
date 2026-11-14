import java.util.Scanner;

class Ride {
    private final String kind;
    private final double perDay;

    Ride(String kind, double perDay) {
        this.kind = kind;
        this.perDay = perDay;
    }

    String getKind() {
        return kind;
    }

    double totalFor(int days) {
        return perDay * days;
    }
}

public class RideRental {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        int days = in.nextInt();

        Ride ride;
        switch (choice) {
            case 1:
                ride = new Ride("Car", 1500.0);
                break;
            case 2:
                ride = new Ride("Bike", 600.0);
                break;
            default:
                ride = new Ride("Truck", 3000.0);
        }

        System.out.println("Vehicle Type: " + ride.getKind());
        System.out.printf("Rental Charge: %.2f%n", ride.totalFor(days));
    }
}
