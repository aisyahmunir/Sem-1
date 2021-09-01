
package com.mycompany.l7q3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class reverse {
    
    public static void main(String[] args) {
        
         try{
            Scanner in = new Scanner(new FileInputStream("q3.txt"));
             try (PrintWriter out = new PrintWriter(new FileOutputStream("reverse.txt"))) {
                 while(in.hasNextLine()){
                     String text = in.nextLine();
                     String reverse = "";
                     for (int i = text.length()-1; i >=0; i--) {
                         reverse += text.charAt(i);
                     }
                     out.println(reverse);
                 }}
        }catch(IOException e){
            System.out.println("Error with I/O");
        }
    }
}
