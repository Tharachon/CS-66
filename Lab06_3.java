//660510657
//Tharachon Warintaweewat

import java.sql.Time;
import java.util.Scanner;

/**
 * Lab06_3
 */
public class Lab06_3 {
    private static boolean check(Scanner sc){
        char type = sc.next().charAt(0);
        return (type == 'R' || type == 'r' || type == '+');
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Timediff timeone, timetwo, timesum;
        if (check(sc)){ // input first
             timeone = new Timediff(sc.nextInt());
        }else{
             timeone = new Timediff(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
        }
        if (check(sc)){ // input second
             timetwo = new Timediff(sc.nextInt());
        }else{
             timetwo = new Timediff(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
        }
        if (check(sc)){ // operation
             timesum = timeone.plus(timetwo);
        }else{
             timesum = timeone.minus(timetwo);
        }
        if (check(sc)){
            System.out.println(timesum.toStringR());
        }else{
            System.out.println(timesum.toStringT());
        }

        sc.close();
    }
}

class Timediff{
    private int second;

    public Timediff(int second){
        this.second = second;
    }
    public Timediff(int day,int hour, int minute, int second){
        this.second = day*86400 + hour*3600 + minute * 60 + second;
    }

    public Timediff plus(Timediff b){
        int secondplus = this.second + b.second;
        return new Timediff(secondplus);
    }

    public Timediff minus(Timediff b){
        int seconddiff = this.second - b.second;
        if (seconddiff < 0) {
            seconddiff =0;
        }
        return new Timediff(seconddiff);
    }

    public String toStringR(){
        return String.valueOf(this.second);
    }
    public String toStringT(){
        int d = this.second/86400;
        int h = (this.second%86400)/3600;
        int m = (this.second%3600)/60;
        int s = this.second%60;
        return String.format("%d:%02d:%02d:%02d",d,h,m,s);
    }
}