package com.mycompany.l8q7;

public class TestMoney {
   
    public static void main(String[] args) {
        // TODO code application logic here
        Money a = new Money();
        a.modify(new int[]{1,0,0,1,1}, new int[]{1});
        System.out.println(a.getBalance());        
        a.setAmount(102.09);
        Money b = new Money();
        b.modify(new int[]{1,0,0,1,1}, new int[]{0});
        System.out.printf("%.2f\n", a.subtraction(b));
        System.out.printf("%.2f\n", a.addition(b));
        System.out.printf("%.2f\n", a.getRoundOff());
    }
     
}
