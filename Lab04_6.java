//660510657
//Tharachon Warintaweewat

import java.util.Scanner;

/**
 * Lab04_6
 */
public class Lab04_6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Student[] student = new Student[num];
        float sum = 0;
        for (int i = 0; i < student.length; i++) {
            student[i] = new Student();
            student[i].setstuNum(sc.next());
            student[i].setmScore(sc.nextInt());
            student[i].setfScore(sc.nextInt());
            student[i].setsumScore();
            sum += student[i].getsumScore();
        }
        float avg = sum/num;
        String year = sc.next();
        String fac_id = sc.next();
        // System.out.println(avg);
        int countTotal = 0,countMore = 0;
        for (int i = 0; i < student.length; i++) {
            if (student[i].searchStu(year, fac_id)) {
                countTotal += 1;
                if(student[i].more_than_avg(avg, student[i].getsumScore())){
                    countMore += 1;
                }
            }
        }
        if (countTotal == 0) {
            System.out.println("None");
        }else{
            System.out.println(countTotal);
            System.out.println(countMore);
        }
        sc.close();
    }
}
class Student{
    private String stuNum;
    private int mScore;
    private int fScore;
    private int sumScore;
    // private int avgScore;


    public void setstuNum(String n){
        this.stuNum = n;
    }
    public void setmScore(int n){
        this.mScore = n;
    }
    public void setfScore(int n){
        this.fScore = n;
    }
    public void setsumScore(){
        this.sumScore = this.mScore + this.fScore;
    }


    public boolean searchStu(String year, String fac_id){
        if (this.stuNum.substring(0, 2).equals(year)){
            if(this.stuNum.substring(2,4).equals(fac_id))  {
                System.out.println(this.stuNum + " " + this.sumScore);
                return true;
            }
        }
        return false;
    }
    public boolean more_than_avg(float avg, int score){
        if (score >= avg) {
            return true;
        }
        return false;
    }


    public String getstuNum(){
        return stuNum;
    }
    public int getsumScore(){
        return sumScore;
    }
}