//660510657
//Tharachon Warintaweewat

import java.util.Scanner;

/**
 * Lab04_5
 */
public class Lab04_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            students[i] = new Student();
            students[i].setName(sc.next());
            students[i].setNsubject(sc.nextInt());
            students[i].createSubject();
            for(int j=0; j< students[i].getNsubject();j++){
                students[i].setSubject(j, sc.nextInt());
            }
        }
        int key = sc.nextInt(), count = 0;
        for (int i = 0; i < students.length; i++) {
            count += students[i].searchSubject(key);
        }
        System.out.println(count);
        sc.close();
    }
}
class Student{
    private String name;
    private int nSubject;
    private int[] subject;
    

    public void setName(String name){
        this.name = name;
    }
    public void setNsubject(int n){
        this.nSubject = n;
    }
    public void createSubject(){
        this.subject = new int[this.nSubject];
    }
    public void setSubject(int m,int n){        
        this.subject[m] = n;
    }


    public int searchSubject(int sub){
        for(int i:this.subject){
            if(i == sub){
                System.out.println(this.name);
                return 1;
            }
        }
        return 0;
    }


    public String getName(){
        return this.name;
    }
    public int getNsubject(){
        return this.nSubject;
    }
    public int[] getSubject(){
        return this.subject;
    }
}