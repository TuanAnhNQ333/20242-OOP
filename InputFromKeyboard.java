import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String args[]) {
        Scanner Keyboard = new Scanner(System.in);

        System.out.println("What's your name?");
        String strName = Keyboard.nextLine();

        System.out.println("How old are you?");
        int iAge = Keyboard.nextInt();

        System.out.println("How tall are you (m)?");
        double dHeight = Keyboard.nextDouble();

        System.out.println("Mrs/ms. " + strName + ", " + iAge + " years old." + " your height is " + dHeight + ".");

    }
}