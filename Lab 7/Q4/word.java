
package com.mycompany.l7q4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class word {
    public static void main(String[] args) {
        
        try {
            Scanner in = new Scanner(new FileInputStream("q3.txt"));
            int lines = 0, character = 0, words = 0;

            while (in.hasNextLine()) {
                lines++;
                int spaces = 0;
                String text = in.nextLine();
                for (int i = 0; i < text.length(); i++) {
                    character++;
                    if (text.charAt(i) == ' ') {
                        spaces++;
                    }
                }
                words += spaces + 1;
            }

            System.out.printf("Lines: %d\n", lines);
            System.out.printf("Characters: %d\n", character);
            System.out.printf("Words: %d\n", words);
        } catch (IOException e) {
            System.out.println("Error");
        }


    }
}
