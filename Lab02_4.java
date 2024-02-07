//660510657
//Tharachon Warintaweewat
import java.util.Scanner;

/**
 * Lab02_4
 */
public class Lab02_4 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numA = sc.nextInt();
        int numB = sc.nextInt();
        int [] list_a = new int[numA];
        list_a = getData(numA);
        findAinB(list_a, numB);
        int max = 0;
        for(int i: list_a){
            if (i > max){
                max = i;
            }
        }
        System.out.println(max);
    }

    private static int[] getData(int a){
        int [] data = new int[a];
        for (int i = 0; i < a; i++ ){
            int val = sc.nextInt();
            data[i] = val;
        }
        return data;
    }

    private static void findAinB(int[] list_a, int n){
        int[] list_b = new int[n];
        list_b = getData(n);
        int count1 = 0;
        for (int i: list_a){
            for (int j: list_b){
                if (i == j){
                    count1 += 1;
                }
            }
            System.out.print(count1 + " ");
            
            count1 = 0;
            
        }
        System.out.println();
    }
}
// move scanner to above all method and add static in front off scanner