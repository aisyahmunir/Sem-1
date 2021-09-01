
package week12;

public class Permanent extends ESS {
    private String category;

    public Permanent(String category) {
        this.category = category;
    }
    
    public double getSalary(){
        if (category.equals("A")) {
            return 4000;
        }
        else if (category.equals("B")) {
            return 3000;
        }
        else if (category.equals("C")) {
            return 2000;
        }
        else
            return 0;
    }
    public String toString() {
        return "Salary : " + getSalary();
    }
}
