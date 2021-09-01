
package com.mycompany.l7q5;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Person {
    
    public static void main(String[] args) {
        
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.dat"));
            int num = in.readInt();
            String[][] array = new String[num][3];
            int i = 0;
            // Read the file and write into array
            try {
                while (true) {
                    String name = in.readUTF();
                    int age = in.readInt();
                    char gender = in.readChar();
                    while (i < array.length) {
                        array[i][0] = name;
                        array[i][1] = Integer.toString(age);
                        array[i][2] = Character.toString(gender);
                        break;
                    }
                    i++;
                }

            } catch (EOFException e) {} // end of write to array
            
            // Sort the array based on name
            String[][] temp2 = new String[1][3];
            for (int pass =1; pass<array.length; pass++){
                for (int row=0; row<array.length-1; row++){
                    if (array[row][0].compareTo(array[row+1][0])>0){
                        temp2[0] = array[row];
                        array[row] = array[row+1];
                        array[row+1] = temp2[0];
                    }
                }
            }
            // To print out the array
            for (int k = 0; k < array.length; k++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(array[k][j] + " ");
                }
                System.out.println("");
            } // end of prinnt

        } catch (IOException e) {
            System.out.println("Error with input file.");
        }


    }
}
