
package com.mycompany.l8q1;

import java.util.Random;

public class Tester {
    public static void main(String[] args) {
    
        Number a = new Number(5,50);    // 5 number, range 0-50
        System.out.println(a.toString());
        System.out.println("Even : "+a.even());
        System.out.println("Prime : "+a.prime());
        System.out.println("Max : "+a.max());
        System.out.println("Min : "+a.min());
        System.out.println("Square : "+a.square());
    }
}
