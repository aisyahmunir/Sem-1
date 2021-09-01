package Q1;

import java.util.Scanner;

public class Triangular {
    
    public static void main(String[] args) {
    
    // call back klau guna void method
    /*    int n = 20;
        triangular(n);  */
        
        Scanner s = new Scanner(System.in);
        for(int i=1; i<=20; i++){   // can change num here
            System.out.print(tria(i)+ " , ");
        }
        
    }
    public static int tria(int num){
        int res = 0;
        for(int i=1; i<=num; i++){
            res += i;
        }
        return res;
    }
    
    // this is other ways in case guna method void
    /* public static void triangular(int n){
        
        for (int i = 1; i <= n; i++)  {
            System.out.printf("%d ", i*(i+1)/2);
    }
    } */
}