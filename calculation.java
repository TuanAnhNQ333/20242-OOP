import java.util.Scanner;

public class calculation{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first num: ");
        double num1 = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter second num: ");
        double num2 = Double.parseDouble(scanner.nextLine());

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;

        Double quotient = null;
        if(num2 != 0) {
            quotient = num1 / num2;
        }

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);

        if(quotient != null) {
            System.out.println("Quotient: " + quotient);
        } else {
            System.out.println("Cannot divide by zero");
        }

        scanner.close();
    }
    
}
