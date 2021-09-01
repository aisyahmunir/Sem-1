package Q6;

import java.util.Scanner;

public class Palindromic {
    
    public static void main(String[] args) {
    
        Scanner s = new Scanner(System.in);
        
        System.out.println("First 20 Emirp :");
        for(int i=1, count = 0; i<Integer.MAX_VALUE && count < 20; i++){
            if (isEmirp(i)){
                count++;
                System.out.print(i+" ");
            }
        }
    }
    public static int reverse(int num){
        int res = 0;
        while(num > 0){
            res = res * 10 + num%10;
            num /= 10;
        }
        return res; 
    }
    public static boolean isPalindrome(int num){
        return reverse(num) == num;
    }
    public static boolean isPrime(int num){
        for(int i=2; i<=num/2; i++){    // i <= sqrt(num)
            if (num%i == 0) return false;
        }
        return true;
    }
    public static boolean isPalindromicPrime(int num){
        return isPrime(num) && isPalindrome(num);
    }
    
    public static boolean isEmirp(int num){
        return isPrime(num) && isPrime(reverse(num)) && !isPalindromicPrime(num);
    }
}
