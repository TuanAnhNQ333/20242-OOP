import java.util.Scanner;

public class linear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a: ");
        double a = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter b: ");
        double b = Double.parseDouble(scanner.nextLine());

        if(a == 0) {
            if(b == 0) {
                System.out.println("Infinitely Solutions");
            } else {
                System.out.println("No solution");
            }
        } else {
            double x = -b/a;
            System.out.println("Solution : x = " + x);
        }

        scanner.close();
    }
}
