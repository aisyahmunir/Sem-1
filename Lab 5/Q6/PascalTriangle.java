package Q6;

import java.util.Scanner;

public class PascalTriangle {
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter the number of row of Pascal Triangle to generate: ");
        int row = s.nextInt();
        
        int[][] array = new int[row][row];
        
        System.out.printf("The pascal triangle with %d row(s)\n", row);
        // Pascal triangle, every first column in every row is 0
        //
        int column = row;
        for (int i = 0; i < row; i++) {
            array [i][0] = 1 ;
            }
        // Print array
        for (int i=1; i<row; i++){
            for (int j =1; j<column;j++){
                array[i][j] = array[i-1][j-1] + array[i-1][j];
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

}

