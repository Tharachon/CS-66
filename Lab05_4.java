//660510657
//Tharachon Warintaweewat

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Lab05_4
 */
public class Lab05_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(sc.next().charAt(0), sc.nextInt());
            students[i].setTotalPoint();
        }
        float totalcreadit = 0;
        float totalpoint = 0;
        for (Student i: students){
            System.out.print(i.getGrade() + " ");
            System.out.print(i.getGradePoint()+ " ");
            System.out.print(i.getCredit()+ " ");
            System.out.print(i.getTotalPoint()+ " ");
            System.out.println();
            totalcreadit += i.getCredit();
            totalpoint += i.getTotalPoint();
        }
        DecimalFormat dc = new DecimalFormat("0.00");
        float gpa = totalpoint/totalcreadit;
        System.out.print((int)(totalcreadit) + " " + (int)totalpoint + " ");
        System.out.print(dc.format(gpa));
        System.out.println();
        sc.close();
    }
}
class Student{
    private char grade;
    private int creadit;
    private int gradePoint;
    private int totalPoint;
    

    public Student(char grade, int creadit){
        this.grade = grade;
        this.creadit = creadit;
        setGradePoint();
    }

    private void setGradePoint(){
        switch (this.grade) {
            case 'A': this.gradePoint = 4;
                break;
            case 'B': this.gradePoint = 3;
                break;
            case 'C': this.gradePoint = 2;
                break;
            case 'D': this.gradePoint = 1;
                break;
            case 'F': this.gradePoint = 0;
        }
    }

    public void setTotalPoint(){
        this.totalPoint = this.creadit * this.gradePoint;
    }
    
    public char getGrade(){
        return grade;
    }
    public int getCredit(){
        return creadit;
    }
    public int getGradePoint(){
        return gradePoint;
    }
    public int getTotalPoint(){
        return totalPoint;
    }

}