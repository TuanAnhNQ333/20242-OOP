import java.util.Scanner;

public class DaysInMonth {

    private final static String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private final static String[] abb = {"Jan.", "Feb.", "Mar.", "Apr.", "May", "June", "July", "Aug.", "Sept.", "Oct.", "Nov.", "Dec."};
    private final static String[] inThreeLetter = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};
    private final static String[] num = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

    private final static int[] commonYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final static int[] leapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static int getMonth(String monthInput) {
        for (int i = 0; i < 12; i++) {
            if (monthInput.equals(month[i])) return i;
            if (monthInput.equals(abb[i])) return i;
            if (monthInput.equals(inThreeLetter[i])) return i;
            if (monthInput.equals(num[i])) return i;
        }
        return -1;
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String monthInput = "";
        int year = -1;
        int month;

        while (true) {
            System.out.print("Enter a month (full name, abbreviation, or number): ");
            monthInput = scanner.nextLine().trim();

            month = getMonth(monthInput);
            if (month != -1) {
                break;
            } else {
                System.out.print("Invalid month input. Please try again! ");
            }
        }

        while (true) {
            System.out.print("Enter a year (non-negative full number): ");

            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year >= 0) {
                    break;
                }
            }

            scanner.nextLine();
            System.out.println("Invalid year input. Please try again.");
        }

        int days = (isLeapYear(year) ? leapYear[month] : commonYear[month]);
        System.out.println("Number of days: " + days);

        scanner.close();
    }
}