
package com.mycompany.l7q6;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Product {
    
    public static void main(String[] args) {
        
        try{
            String[][] product = new String[7][3];
            String[][] order = new String[5][3];
            Scanner in = new Scanner(new FileInputStream("product.txt"));
            
            int i = 0;
            while(in.hasNextLine()){
                String temp = in.nextLine();
                String record[] = temp.split(",");
                product[i++] = record;
            }
            
            in  = new Scanner(new FileInputStream("order.txt"));
            i = 0;
            while(in.hasNextLine()){
                String temp = in.nextLine();
                String record[] = temp.split(",");
                order[i++] = record;
            }
            
            System.out.println("ProductID\tProduct Name\tQuantity\tPricePerUnit\tTotal");
            for(String[] ord : order){
                String productID = ord[1];
                int quantity = Integer.parseInt(ord[2]);
                for(String[] item : product){
                    if (productID.equals(item[0])){
                        double pricePerUnit = Double.parseDouble(item[2]);
                        double totalPrice = quantity * pricePerUnit;
                        System.out.printf("%s\t%20s\t%8d\t%10.2f\t%6.2f\n", productID, item[1], quantity, pricePerUnit, totalPrice);
                    }
                }
            }
        }catch(IOException e){
            System.out.println("Error");
        }
        
    }
}
