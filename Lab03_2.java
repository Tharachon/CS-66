//660510657
//Tharachon Warintaweewat
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Lab03_2
 */
public class Lab03_2 {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        char course = sc.next().charAt(0);
        int time = sc.nextInt();
        char course1 = sc.next().charAt(0);
        int time1 = sc.nextInt();

        //create a tutor instance
        Tutor tutor = new Tutor();
        tutor.setCourse(course);
        tutor.setTime(time);

        Tutor tutor1 = new Tutor();
        tutor1.setCourse(course1);
        tutor1.setTime(time1);
        
        double result1 = tutor.calResult();
        double result2 = tutor1.calResult();
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.print(df.format(result1) + " ");
        System.out.print(df.format(result2));
    }
}
    class Tutor{
        private char course;
        private int time;
        private double result;

        public double calResult(){
            if (course == 'm'){
                result = 700 * time;
            }else{
                for (int i=1; i<=time; i++){
                    if (i < 2){
                        result = 800;
                    }
                    else if(i < 6){
                        result += 780;
                    }
                    else if(i < 11){
                        result += 750;
                    }
                    else{
                        result += 650.50;
                    }
                }
            }
            return result;
        }

        public void setCourse(char course) {
            this.course = Character.toLowerCase(course);
        }
        public void setTime(int time) {
            this.time = time;
        }

        public char getCourse(){
            return course;
        }
        public int getTime(){
            return time;
        }
    }