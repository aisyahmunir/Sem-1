package Q4;

import java.util.Scanner;

public class Calendar {
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter a year : ");
        int year = s.nextInt();
        System.out.println("Enter the first day (e.g. Sun-0, Non-1, ...) : ");
        int day1 =s.nextInt();
        
        int jan = 1, feb = 28, mar = 31, apr = 30;
        
        //Check for leap year
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            feb += 1;
        }
        int day1ofMay = jan + feb + mar + apr + day1;
        day1ofMay %= 7;
        
        System.out.println("May 2020");
        System.out.println("Sun\tMon\tTues\tWed\tThurs\tFri\tSat");
        // print the spaces before the first day of May
        for (int i = 0; i < day1ofMay; i++) {
            System.out.print("\t");
        }
        for (int i = 1; i < 31; i++) {
            System.out.print(i + "\t"); // 7 % 7 = 0
            if ((i + day1ofMay) % 7 == 0) System.out.println(" ");
        }
    }
}

