
package week12;

public class Square implements Number, Comparable {
    private int num;

    public Square(int num) {
        this.num = num;
    }
    
    public int getSpecial() {
        return num*num;
    }

    public int getNum() {
        return num;
    }
    
    public String toString() {
        return "Square is " + getSpecial();
    }
    public int compareTo(Object o){
        if (num>  ((Square) (o)).getNum())
            return 1;
        else
            return -1;        
    }
    
}
