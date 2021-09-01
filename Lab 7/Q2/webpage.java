package Q2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class webpage {
    
    public static void main(String[] args) {
        
         try {
            URL u = new URL("https://fsktm.um.edu.my/");
            URLConnection cnn = u.openConnection();
            InputStream stream = cnn.getInputStream();
            Scanner in = new Scanner(stream);
            
             try (PrintWriter p = new PrintWriter(new FileOutputStream("index.htm"))) {
                 while (in.hasNextLine()){
                     p.write(in.nextLine());
                 }}
        } catch (IOException e) {
            System.out.println("IO Error:" + e.getMessage());
        }
    }
}
