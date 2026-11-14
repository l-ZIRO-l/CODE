import java.util.Scanner;

abstract class Physician {
    protected final String title;
    protected final double visitFee;

    Physician(String title, double visitFee) {
        this.title = title;
        this.visitFee = visitFee;
    }

    double finalBill(double labCharges) {
        return visitFee;
    }
}

class FamilyDoctor extends Physician {
    FamilyDoctor() {
        super("General Physician", 500.0);
    }
}

class ExpertDoctor extends Physician {
    ExpertDoctor() {
        super("Specialist", 1000.0);
    }
}

class CasualtyDoctor extends Physician {
    CasualtyDoctor() {
        super("Emergency Doctor", 1500.0);
    }

    @Override
    double finalBill(double labCharges) {
        return visitFee + labCharges;
    }
}

public class ClinicBill {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        double lab = in.nextDouble();

        Physician p;
        switch (choice) {
            case 1:
                p = new FamilyDoctor();
                break;
            case 2:
                p = new ExpertDoctor();
                break;
            default:
                p = new CasualtyDoctor();
        }

        System.out.println("Doctor Type: " + p.title);
        System.out.printf("Consultation Charge: %.2f%n", p.visitFee);
        System.out.printf("Test Charges: %.2f%n", lab);
        System.out.printf("Total Bill: %.2f%n", p.finalBill(lab));
    }
}
