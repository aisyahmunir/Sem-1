package Q1;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Scanner;

public class binaryFile {
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        // Write file
        try {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("coursename.dat"))) {
                out.writeUTF("WXES1116-Programming I\n");
                out.writeUTF("WXES1115-Data Structure\n");
                out.writeUTF("WXES1110-Operating System\n");
                out.writeUTF("WXES1112-Computing Mathematics\n");
            }
        } catch (IOException e) {
            System.out.println("Problem with input.");
        }
        // Read file
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("coursename.dat"));
            int index = 0;
            String[][] course = new String[4][2];
            try{
                while(true){
                    String temp = in.readUTF();
                    if (!temp.equals("")){
                        String arr[] = temp.split("-");
                        course[index++] = arr; 
                    }
                }
            }catch (EOFException ex){}
            System.out.println("Enter a course code: ");
            String code = s.nextLine();
            for (int i = 0; i < 4; i++) {
                if (course[i][0].equals(code)){
                    System.out.println(course[i][1]);
                    break;
                }
            }
        }catch (IOException e){
            
        }
    }
}
