package appoinment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class pw {
    
    public static void main(String[] args) {
        
        try {
            PrintWriter o = new PrintWriter(new FileOutputStream("Patient.txt"));

            o.close();
            }
            catch(IOException e){
                System.out.println("Problem with file output.");
            }
    
        Scanner s = new Scanner(System.in);
        
        System.out.println("\t\t\t\tiHealth\n\n");
        
        System.out.println("How can i help you? (Choose 1 or 2)\n");
        System.out.println("1. Make Appoinment ");
        System.out.println("2. Check My Appoinment\n");
        
        System.out.println("Enter your choice : ");
        int ch = s.nextInt();
        
        try{
            
            File file = new File("Patient.txt");
            
            FileWriter app = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(app);
            
            System.out.println("-------------------------------------------------------------------");

        //while(!text.equals("n")) {
        if(ch == 1){
            System.out.println("Appoinment Section\n");
            System.out.println("Is this your first time making appoinment ?\n");
            
            System.out.println("Enter (YES/NO) : ");
            String yn = s.next();
            
            String y = "yes";
            String n = "no";

            if(yn.equalsIgnoreCase(y)){
                
                System.out.print("\nEnter Full Name : ");
                String name = s.nextLine();
                bw.write(name);
                        
                System.out.print("\nIC/Passport : ");
                String ic = s.nextLine();
                bw.write(ic);
                
                System.out.print("\nEnter phone number : ");
                String phone = s.nextLine();
                bw.write(phone);
                
                System.out.print("\nEnter Date (day:month) : ");
                String date = s.nextLine();
                bw.write(date);

                
                System.out.println("\nEnter Time : ");
                String time = s.nextLine(); 
                bw.write(time);
 
                }
            
            
            else if(yn.equalsIgnoreCase(n)){
                
                System.out.print("\nEnter Full Name : ");
                String name = s.nextLine();
                bw.write(name);
                
                System.out.print("\nIC/Passport : ");
                String ic = s.nextLine();
                bw.write(ic);
               }
            
            else if(ch == 2){
               // 
            } 
            
            else{
                System.out.println("");
                System.out.println("Error!");
            }
            
        }
        }
         catch(IOException e){
                System.out.println("Problem with file output.");
            }
    }   
}
