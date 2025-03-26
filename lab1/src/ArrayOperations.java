import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("nhap so phan tu cua mang : ");
        int n = scanner.nextInt();

        double[] array = new double[n];

        System.out.println("nhap cac phan tu cua mang: ");
        for(int i = 0; i < n; i ++) {
            System.out.print("phan tu thu " + (i + 1) + ": ");
            array[i] = scanner.nextDouble();
        }

        Arrays.sort(array);

        double sum = 0; 
        for(double num : array) {
            sum += num;
        }
        double average = sum/n;

        System.out.println("\nMang sau khi sap xep: " + Arrays.toString(array));
        System.out.println("Tong cac phan tu: " + sum);
        System.out.println("Gia tri trung binh : " + average);

        scanner.close();
    }
}
