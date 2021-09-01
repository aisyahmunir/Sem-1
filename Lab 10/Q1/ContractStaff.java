
package l10q1;

public class ContractStaff extends EmployeeSalarySystem{
    private double sales;
    
    public ContractStaff(String name, double sales){
        this.name = name;
        this.sales = sales;
        type = "Contract Staff";
        salary = 500 + 0.5 * sales;
    }
    @Override
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.printf("Sales: %.2f\n" , sales);
        System.out.printf("Salary: %.2f\n" , salary);
    }
   
