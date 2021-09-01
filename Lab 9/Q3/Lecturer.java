package com.mycompany.l9q3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Lecturer extends PersonProfile{
    private String[] courseName, courseCode, semester, session;
    private int[] numberOfStudents;
    private double[] creditHour;
    
    public Lecturer(String name, String gender, String dob){
        super(name, gender, dob);
    }
    
    public void retrieve(){
        int lines = 0;
        try{
            Scanner s = new Scanner(new FileInputStream("lecturer.txt"));
            while(s.hasNextLine()){
                lines++;
                s.nextLine();
            }
            s.close();
            int n = lines / 6;
            courseName = new String[n];
            courseCode = new String[n];
            semester = new String[n];
            session = new String[n];
            creditHour = new double[n];
            numberOfStudents = new int[n];
            s = new Scanner(new FileInputStream("lecturer.txt"));
            
            for(int i=0; i<n; i++){
                courseName[i] = s.nextLine();
                courseCode[i] = s.nextLine();
                session[i] = s.nextLine();
                semester[i] = s.nextLine();
                creditHour[i] = Double.parseDouble(s.nextLine());
                numberOfStudents[i] = Integer.parseInt(s.nextLine());
            }
            s.close();
        }catch(IOException e){}
    }
    
    public void computeCreditHour(){
        for(int i=0; i<creditHour.length; i++){
            int num = numberOfStudents[i];
            if (num >= 150) creditHour[i] *= 3;
            else if (num >= 100) creditHour[i] *= 2;
            else if (num >= 50) creditHour[i] *= 1.5;
        }
    }
    
    public void display(){
        retrieve();
        computeCreditHour();
        super.display();
        for(int i=0; i<courseCode.length; i++){
            System.out.println("Course Name: " + courseName[i]);
            System.out.println("Course Code: " + courseCode[i]);
            System.out.println("Session: " + session[i]);
            System.out.println("Semester: " + semester[i]);
            System.out.println("Credit Hour: " + creditHour[i]);
            System.out.println("Number of students: " + numberOfStudents[i]);
            System.out.println("");
        }
    }
}

