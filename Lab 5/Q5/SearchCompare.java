package Q5;

import java.util.Random;
import java.util.Scanner;

public class SearchCompare {
    
    public static void main(String[] args) {
        
        Random r = new Random();
        Scanner s = new Scanner(System.in);
        System.out.println("A list of 20 random integer within 0 to 100\n");
        int[] arr = new int[20];
        for(int i=0; i<20; i++){
            arr[i] = r.nextInt(101);
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
        System.out.println("Array in descending order\n");
        for(int pass = 0; pass < arr.length - 1; pass++){
            for(int i=0; i<arr.length - 1; i++){
                if (arr[i] < arr[i + 1]){ //Can change descending to assending 
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i+1] = temp;
                }
            }
        }
        for(int i=0; i<20; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
        
        System.out.println("Enter a number to search: ");
        int target = s.nextInt();
        boolean found = false;
        
        // linear search
        int count = 1;
        for(int number : arr){
            if ( number == target){
                found =  true;
                break;
            }
            count++;
        }
        if (found){
            System.out.printf("Linear Search - %d loops\n", count);
        }
        
        count = 0;
        // binary search
        int left = 0, right = arr.length-1;
        found = false;
        
        while(left <= right){
            int mid = (left + right) / 2;
            count++;
            if (arr[mid] == target){
                found = true;
                break;
            }
            else if (arr[mid] < target){
               right = mid - 1; 
            }
            else{
                left = mid + 1;
            }
        }
        if (found){
            System.out.printf("Binary Search - %d loops\n", count);
        }
    }
}    
    
