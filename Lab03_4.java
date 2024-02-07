//660510657
//Tharachon Warintaweewat

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Lab03_4
 */
public class Lab03_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();

        Time time = new Time();
        time.settotal(total);
        time.setday();
        time.sethour();
        time.setminute();
        time.setsecond();

        DecimalFormat format = new DecimalFormat("00");
        System.out.print(time.getday()+":");
        System.out.print(format.format(time.gethour())+":");
        System.out.print(format.format(time.getminute())+":");
        System.out.print(format.format(time.getsecond()));
    }
    
}
class Time{
    private int total;
    private int day;
    private int second;
    private int minute;
    private int hour;

    public void settotal(int total){
        this.total = total;
    }
    public void setday(){
        this.day = calday();
    }
    public void setsecond(){
        this.second = calsecond();
    }
    public void setminute(){
        this.minute = calminute();
    }
    public void sethour(){
        this.hour = calhour();
    }

    public int gettotal(){
        return total;
    }
    public int getday(){
        return day;
    }
    public int gethour(){
        return hour;
    }
    public int getminute(){
        return minute;
    }
    public int getsecond(){
        return second;
    }

    public int calday(){
        return total/86400;
    }
    public int calhour(){
        return (total%86400)/3600;
    }
    public int calminute(){
        return (total%3600)/60;
    }
    public int calsecond(){
        return (total%60);
    }
}