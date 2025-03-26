import java.util.Scanner;

public class Equation{

    public static void solve1(Scanner scanner) {
        System.out.println("Enter the coefficient a (a != 0): ");
        double a = scanner.nextDouble();
        System.out.println("Enter the constant b: ");
        double b = scanner.nextDouble();

        if (a == 0) {
            System.out.println("a cannot be zero.");
        } else {
            double solution = -b / a;
            System.out.println("The solution is x = " + solution);
        }
    }

    public static void solve2(Scanner scanner) {
        System.out.println("For equation 1: a11 * x1 + a12 * x2 = b1");
        System.out.print("Enter a11: ");
        double a11 = scanner.nextDouble();
        System.out.print("Enter a12: ");
        double a12 = scanner.nextDouble();
        System.out.print("Enter b1: ");
        double b1 = scanner.nextDouble();

        System.out.println("For equation 2: a21 * x1 + a22 * x2 = b2");
        System.out.print("Enter a21: ");
        double a21 = scanner.nextDouble();
        System.out.print("Enter a22: ");
        double a22 = scanner.nextDouble();
        System.out.print("Enter b2: ");
        double b2 = scanner.nextDouble();

        double determinant = a11 * a22 - a12 * a21;
        double determinantX1 = b1 * a22 - b2 * a12;
        double determinantX2 = a11 * b2 - a21 * b1;

        if (determinant == 0) {
            if (determinantX1 == 0 && determinantX2 == 0) {
                System.out.println("The system has infinitely many solutions.");
            } else {
                System.out.println("The system has no solution.");
            }
        } else {
            double x1 = determinantX1 / determinant;
            double x2 = determinantX2 / determinant;
            System.out.println("The solution is: x1 = " + x1 + ", x2 = " + x2);
        }
    }

    public static void solve3(Scanner scanner) {
        System.out.println("Enter the coefficient a (a != 0): ");
        double a = scanner.nextDouble();
        System.out.println("Enter the coefficient b: ");
        double b = scanner.nextDouble();
        System.out.println("Enter the constant c: ");
        double c = scanner.nextDouble();

        if (a == 0) {
            System.out.println("a cannot be zero.");
            return;
        }

        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("The equation has two distinct real roots: x1 = " + root1 + ", x2 = " + root2);
        } else if (delta == 0) {
            double root = -b / (2 * a);
            System.out.println("The equation has one real double root: x = " + root);
        } else {
            System.out.println("The equation has no real roots.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the type of equation to solve:");
        System.out.println("1. First-degree equation (ax + b = 0)");
        System.out.println("2. System of first-degree equations (two variables)");
        System.out.println("3. Second-degree equation (ax² + bx + c = 0)");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                solve1(scanner);
                break;
            case 2:
                solve2(scanner);
                break;
            case 3:
                solve3(scanner);
                break;
            default:
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }

}