import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("nhap so hang cua ma tran : ");
        int rows = scanner.nextInt();
        System.out.print("nhap so cot cua ma tran : ");
        int cols = scanner.nextInt();

        int[][] matrixA = new int[rows][cols];
        int[][] matrixB = new int[rows][cols];
        int[][] resultMatrix = new int[rows][cols];

        // ma tran A : 
        System.out.println("nhap cac phan tu cua ma tran A : ");
        for(int i = 0; i < rows; i ++) {
            for(int j = 0; j < cols; j ++) {
                System.out.print("A[" + i + "][" + j + "] = " );
                matrixA[i][j] = scanner.nextInt();
            }
        }
        
        // ma tran B : 
        System.out.println("Nhập các phần tử của ma trận B:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("B[" + i + "][" + j + "] = ");
                matrixB[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        System.out.println("Ma trận tổng là:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
