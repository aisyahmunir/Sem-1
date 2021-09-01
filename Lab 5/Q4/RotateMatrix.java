package Q4;

public class RotateMatrix {
    
    public static void main(String[] args) {
        
        int[][] matrix = {
            {1, 5, 7},
            {3, 6, 9},
            {5, 3, 9}
        } ;
        
        System.out.println("3 by 3 Matrix : ");
        System.out.println("1 5 7\n3 6 9\n5 3 9");
        int[][] rotated = new int [3][3];
        //rotate logic here
        System.out.println("After rotates 90 degrees (Clockwise) : ");
        for(int i = 0; i<3; i++){
            for (int j = 0; j < 3; j++){
                rotated[i][j] = matrix[matrix.length - j - 1][i];
                System.out.print(rotated[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
