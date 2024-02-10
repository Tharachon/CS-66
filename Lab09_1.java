/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//660510657 
//Tharachon Warintaweewat

import java.util.Scanner;
//package lab09_1;

/**
 *
 * @author CSB_Lab
 */
public class Lab09_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        Student[] std = new Student[250];
        int id = 0;
        char choice;
        String name = new String();
        int mid, fin;
        do{
            choice = input.next().charAt(0);
            choice = Character.toLowerCase(choice);
            
            name = input.next();
            mid = input.nextInt();
            fin = input.nextInt();
            
            if (choice == 'u'){
                std[id] = new Undergraduate_Student();
                std[id].setInfo(name, mid, fin);
                ((Undergraduate_Student) std[id]).setProjectScore(input.nextInt());
            }
            else if (choice == 'g'){
                std[id] = new Graduate_Student();
                std[id].setInfo(name, mid, fin);
                ((Graduate_Student)std[id]).setPublicationNo(input.nextInt());
            }
            id++;
            choice = input.next().charAt(0);
            choice = Character.toLowerCase(choice);
        }while(choice == 'y');
        
        reportGrade(std, id);
        
        input.close();
    }
    public static void reportGrade(Student[] std, int n){
        String name;
        int num_s = 0, mid, fn, totalScore, i;
        char grade;
        for(i=0;i<n;i++){
            name = std[i].getName();
            mid = std[i].getMidtermScore();
            fn = std[i].getFinalScore();
            totalScore = mid+fn;
            grade = std[i].calGrade(totalScore);
            if (grade == 'S'){
                num_s++;
            }
            System.out.println(name + " : " + grade);
        }
        
        System.out.println("U = " + (n-num_s)+ "\nS = "+ num_s);
    }
}
abstract class Student{
    protected String name;
    protected int midtermScore;
    protected int finalScore;
    
    public void setInfo(String s1, int i1, int i2){
        this.name = s1;
        this.midtermScore = i1;
        this.finalScore = i2;
    }
    
    public String getName(){
        return this.name;
    }
    public int getMidtermScore(){
        return this.midtermScore;
    }
    public int getFinalScore(){
        return this.finalScore;
    }
    public abstract char calGrade(int i1);
}

class Undergraduate_Student extends Student{
    private int projectScore;
    
    public void setProjectScore(int i1){
        this.projectScore = i1;
    }
    public int getProjectScore(){
        return this.projectScore;
    }
    public char calGrade(int totalScore){
        return (totalScore >= 50 && projectScore >= 50)?'S':'U';
    }
}
class Graduate_Student extends Student{
    private int publicationNo;
    
    public void setPublicationNo(int i1){
        this.publicationNo = i1;
    }
    public int getPublicationNo(){
        return this.publicationNo;
    }
    public char calGrade(int totalScore){
        return (totalScore >= 60 && publicationNo >= 2)?'S' : 'U';
    }
}