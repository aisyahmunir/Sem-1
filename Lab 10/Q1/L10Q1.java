
package l10q1;

public class L10Q1 {

    public static void main(String[] args) {
        PermanentEmployee a = new PermanentEmployee("Donald", 'C');
        a.display();
        
        ContractStaff b = new ContractStaff("John", 123);
        b.display();
        
        TemporaryStaff c = new TemporaryStaff("Lee", 10);
        c.display();
    }
    
}

