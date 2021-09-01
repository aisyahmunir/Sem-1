package com.mycompany.l9q2;

public class PersonProfile {
    protected String name, gender, dob;
    
    public PersonProfile(String name, String gender, String dob){
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }
    public void display(){
        System.out.println("Name: "+name+"\n"+
                           "Gender: "+ gender +"\n"+
                           "Date of Birth: "+ dob+"\n");
    }
}
