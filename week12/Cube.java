/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week12;

public class Cube implements Number {
    private int num;

    public Cube(int num) {
        this.num = num;
    }
    
    public int getSpecial() {
        return num*num*num;
    }
    
    public String toString() {
        return "Cube is " + getSpecial();
    }
    
}

