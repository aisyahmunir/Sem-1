package com.mycompany.l9q2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Student extends PersonProfile{
    private String[] courseName, courseCode, semester, session, grade;
    private int[] mark;
    private String fileName;
    
    public Student(String name, String gender, String dob, String fileName){
        super(name, gender, dob);
        this.fileName = fileName;
    }
    
    public void retrieve(){
        int lines = 0;
        try{
            Scanner s = new Scanner(new FileInputStream(fileName + "lecturer.txt"));
            while(s.hasNextLine()){
                lines++;
                s.nextLine();
            }
            s.close();
            int n = lines / 5;
            courseName = new String[n];
            courseCode = new String[n];
            semester = new String[n];
            session = new String[n];
            grade = new String[n];
            mark = new int[n];
            s = new Scanner(new FileInputStream(fileName + "lecturer.txt"));
            
            for(int i=0; i<n; i++){
                courseName[i] = s.nextLine();
                courseCode[i] = s.nextLine();
                session[i] = s.nextLine();
                semester[i] = s.nextLine();
                mark[i] = Integer.parseInt(s.nextLine());
            }
            s.close();
        }catch(IOException e){}
    }
    
    public void getGrade(){
        for(int i=0; i<mark.length; i++){
            if (mark[i] >= 85) grade[i] = "A";
            else if (mark[i] >= 75) grade[i] = "A-";
            else if (mark[i] >= 70) grade[i] = "B+";
            else if (mark[i] >= 65) grade[i] = "B";
            else if (mark[i] >= 60) grade[i] = "B-";
            else if (mark[i] >= 55) grade[i] = "C+";
            else if (mark[i] >= 50) grade[i] = "C";
            else if (mark[i] >= 45) grade[i] = "D";
            else if (mark[i] >= 35) grade[i] = "E";
            else grade[i] = "F";
        }
    }
    
    public void display(){
        retrieve();
        getGrade();
        super.display();
        for(int i=0; i<courseCode.length; i++){
            System.out.println("Course Name: " + courseName[i]);
            System.out.println("Course Code: " + courseCode[i]);
            System.out.println("Session: " + session[i]);
            System.out.println("Semester: " + semester[i]);
            System.out.println("Mark: " + mark[i]);
            System.out.println("Grade: " + grade[i]);
            System.out.println("");
        }
    }
}
