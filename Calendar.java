package Sagar;
import java.util.Scanner;

public class Calendar {

    static int monthCode(int m) {
        System.out.println();
        switch (m) {
            case 1: 
                System.out.print("January");
                return 0;
            case 2:
                System.out.print("February");
                return 3; 
            case 3:
                System.out.print("March");
                return 3;
            case 4:
                System.out.print("April");
                return 6;
            case 5:
                System.out.print("May");
                return 1;
            case 6:
                System.out.print("June");
                return 4;
            case 7:
                System.out.print("July");
                return 6;
            case 8:
                System.out.print("August");
                return 2;
            case 9:
                System.out.print("September");
                return 5;
            case 10:
                System.out.print("October");
                return 0;
            case 11:
                System.out.print("November");
                return 3;
            case 12:
                System.out.print("December");
                return 5;
            default:
                System.out.print("Invalid month!");
                break;
        }
        return 0;
    }

    static int centuryCode(int year) {
        if (year > 1700 && year <= 1800)
            return 4;
        else if (year > 1800 && year <= 1900)
            return 2;
        else if (year > 1900 && year <= 2000)
            return 0;
        else if (year > 2000 && year <= 2100)
            return 6;
        else if (year > 2100 && year <= 2200)
            return 4;
        else if (year > 2200 && year <= 2300)
            return 2;
        else if (year > 2300 && year < 2400)
            return 0;
        else
            System.out.println("Invalid year");
        return 0;
    }

    static int leapCode(int year, int month) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            if (month == 1 || month == 2)
                return 1;
        }
        return 0;
    }

    static void printMonth(int space, int x) {
        System.out.println();
        String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        System.out.println();
        for (String day : week)
            System.out.print(day + " ");
        System.out.println();
        int n = 1;
        for (int i = 1; i <= space; i++)
            System.out.print("    ");
        for (int i = 1; i <= 6 - space + 1; i++)
            System.out.printf("%4d", n++);
        System.out.println();
        for (int j = 1; j <= 5; j++) {
            for (int i = 1; i <= 7; i++)
                if (n <= x)
                    System.out.printf("%4d", n++);
            System.out.println();
        }
    }

    static int monthDate(int month, int year) {
        switch (month) {
            case 1:
                return 31;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
                    return 29;
                return 28;
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year, month = 1, date = 1, yc, mc, cc, lc, m;
        System.out.println("Enter the year:");
        year = scanner.nextInt();
        System.out.println("\t***\t**\t*****");
        System.out.printf("Calendar of "+ year);
        yc = (year % 100 + (year % 100) / 4) % 7;
        cc = centuryCode(year);
        for (int i = 1; i <= 12; i++) {
            mc = monthCode(month);
            m = monthDate(month, year);
            lc = leapCode(year, month);
            int space = (yc + mc + cc + date - lc) % 7;
            printMonth(space, m);
            month++;
        }
    }
}