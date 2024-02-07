//660510657
//Tharachon Warinatweewat
// import java.util.Arrays;
import java.util.Scanner;

/**
 * Lab03_3
 */
public class Lab03_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        Grade [] data = new Grade[no];
        for (int i=0;i<no;i++){
            String stuNum = sc.next();
            int mScore = sc.nextInt();
            int fScore = sc.nextInt();
            data[i] = new Grade();
            data[i].setstuNum(stuNum);
            data[i].setmScore(mScore);
            data[i].setfScore(fScore);
            data[i].setsumScore();
            data[i].setgrade();
        }
        int cut = sc.nextInt();
        for (int i=0;i<no;i++){
            if(((i) % cut)==0 && i!=0){
                System.out.println();
            }
            System.out.print((i+1)+") ");
            System.out.print(data[i].getstuNum()+" ");
            System.out.print(data[i].getsumScore()+" ");
            System.out.print(data[i].getGrade()+" ");
            System.out.println();
        }
        sc.close();
    }
    
}

class Grade{
    private String stuNum;
    private int mScore;
    private int fScore;
    private int sumScore;
    private String grade;

    public void setstuNum(String stuNum){
        this.stuNum = stuNum;
    }
    public void setmScore(int mScore){
        this.mScore = mScore; 
    }
    public void setfScore(int fScore){
        this.fScore = fScore;
    }
    public void setsumScore(){
        this.sumScore = calsumScore();
    }
    public void setgrade(){
        this.grade = calGrade();
    }


    public String getstuNum(){
        return stuNum;
    }
    public int getmScore(){
        return mScore;
    }
    public int getfScore(){
        return fScore;
    }
    public String getGrade(){
        return grade;
    }
    public int getsumScore(){
        return sumScore;
    }


    public int calsumScore(){
        int temp = mScore + fScore; 
        return temp;
    }
    public String calGrade(){
        // sumScore = calsumScore();
        if (sumScore>=85){
            return "A";
        }
        else if(sumScore>=80){
            return "B+";
        }
        else if(sumScore>=75){
            return "B";
        }
        else if(sumScore>=60){
            return "C+";
        }
        else if(sumScore>=55){
            return "C";
        }
        else if(sumScore>=50){
            return "D+";
        }
        else if(sumScore>=45){
            return "D";
        }
        else{
            return "F";
        }
    }
}