package Q2;

public class multiPrints {
    
    public static void main(String[] args) {

        // triangle
        multiPrint(2, ' ');         // to space
        multiPrint(1, '*');
        System.out.println(" ");
        multiPrint(1, ' ');
        multiPrint(3, '*');
        System.out.println("");
        multiPrint(5, '*');
        System.out.println(" ");
        
        System.out.println(" ");
        
        // diamond
        multiPrint(2, ' ');
        multiPrint(1, '*');
        System.out.println(" ");
        multiPrint(1, ' ');
        multiPrint(3, '*');
        System.out.println("");
        multiPrint(5, '*');
        System.out.println("");
        multiPrint(5, '*');
        System.out.println("");
        multiPrint(1, ' ');
        multiPrint(3, '*');
        System.out.println("");
        multiPrint(2, ' ');
        multiPrint(1, '*');
        System.out.println(" ");
    }
    public static void multiPrint(int n, char c){
        for(int i=0; i < n; i++){
            System.out.print(c);
        }
    }
    
}
