package Q3;

import java.util.Random;
import java.util.Scanner;

public class WorkHours {
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        
        System.out.println("Enter the number of employee: ");
        int num = s.nextInt();
        
        int[][] arr = new int[num][8]; // 7 days + total hours
        for(int i=0; i<num; i++){
            int totalHours = 0;
            for(int j=0; j<7; j++){
                arr[i][j] = r.nextInt(8) + 1;
                totalHours += arr[i][j];
            }
            arr[i][7] = totalHours;
        }
        
        System.out.println("Employee\tSun\tMon\tTues\tWeds\tThurs\tFri\tSat\tTotal Hours");
        for(int i=0; i<num; i++){
            System.out.print( i + 1 + "\t\t");
            for(int j=0; j<8; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}
