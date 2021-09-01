/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week12;


public class Temporary extends ESS {
    private double hours;

    public Temporary(double hours) {
        this.hours = hours;
    }
    public double getSalary(){
        return hours*15;
    }
    public String toString() {
        return "Salary : " + getSalary();
    }
}