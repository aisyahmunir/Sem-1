package Q6;


import java.util.Scanner;


public class Energy {
    
    public static void main(String[] args) {
        
        Scanner water = new Scanner(System.in);
        float W;
        
        System.out.println("Enter amount of water (g) : ");
        W = water.nextFloat();
        
        Scanner temp = new Scanner(System.in);
        float T ;
        
        System.out.println("Enter intial temperature of water (F) : ");
        T = temp.nextFloat();
        
        Scanner suhu = new Scanner(System.in);
        float S ;
        
        System.out.println("Enter final temperature of water (F) : ");
        S = suhu.nextFloat();
        
        double Q;
        
        Q = (W/1000*(((S - T))/1.8)*4184);
        
        System.out.println("The energy needed is ");
        System.out.printf("%.6e", Q);
    }
}

