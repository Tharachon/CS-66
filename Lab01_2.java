//660510657
//Tharachon Warintaweewat
import java.util.*;
/**
 * Lab01_2
 */
public class Lab01_2 {
    private static void bottleCount(int a){
        int total;
        int count = 0;
        int temp = 0;
        
        while (a >= 5){
            total = a / 5;
            ++ count;
            a = a - total * 5 + total * 2;
            temp += total * 5;
        }
        temp += a;
        System.out.printf("%d %d %d",temp,count, a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        
        bottleCount(a);
    }
    
}
