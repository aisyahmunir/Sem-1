package week13;

public class FoPException extends Exception {
    
   public FoPException() {
      super("I don't know how to solve the problem");
   }
   public FoPException(String s) {
      super(s);
   }

}
