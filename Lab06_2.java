//660510657
//Tharachon Warintaweewat
import java.util.Scanner;

/**
 * Lab06_2
 */
public class Lab06_2 {
    
    private static Timestamp readTimestamp(Scanner input){
        String strInput[] = input.nextLine().trim().split(":");

        int day = Integer.valueOf(strInput[0]);
        int hour = Integer.valueOf(strInput[1]);
        int minute = Integer.valueOf(strInput[2]);
        int second = Integer.valueOf(strInput[3]);
        
        return new Timestamp(day, hour, minute, second);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Timestamp timeA = readTimestamp(sc);
        Timestamp timeB = readTimestamp(sc);

        Timestamp result = timeA.diff(timeB);

        System.out.println(result.toString());
        sc.close();
    }
}
class Timestamp{
    private int d, h, m, s;

    public Timestamp(int d, int h, int m, int s){
        this.d = d;
        this.h = h;
        this.m = m;
        this.s = s;
    }

    public Timestamp diff(Timestamp b){
        int sumA = this.d*86400 + this.h*3600 + this.m*60 + this.s;
        int sumB = b.d*86400 + b.h*3600 + b.m*60 + b.s;
        int daydiff = (sumA-sumB)/86400;
        int hourdiff = ((sumA-sumB)%86400)/3600;
        int minutediff = ((sumA-sumB)%3600)/60;
        int seconddiff = (sumA-sumB)%60;
        return new Timestamp(Math.abs(daydiff),Math.abs(hourdiff), Math.abs(minutediff), Math.abs(seconddiff));
    }

    public String toString(){
        return String.format("%d:%02d:%02d:%02d",this.d,this.h,this.m,this.s );
    }
}