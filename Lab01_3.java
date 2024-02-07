//660510657
//Tharachon Warintaweewat
import java.util.Scanner;

/**
 * Lab01_3
 */
public class Lab01_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line  = sc.nextInt();
        int [] data = new int[line];
        for (int i = 0; i < line; i++ ){
            int val = sc.nextInt();
            data[i] = val;
        }
        int count1 = 0;
        int count2 = 0;
        int key = sc.nextInt();
        for (int i : data){
            if (i >= key){
                System.out.print(i + " ");
                count1 += 1;
            }
        }
        if (count1 == 0)
            System.out.print("-");
        System.out.println();
        for (int i : data){
            if (i < key){
                System.out.print(i + " ");
                count2 +=1;
            }
        }
        if (count2 == 0){
            System.out.println("-");
        }
    }
}