
//660510657
//Tharachon Warintaweewat
import java.util.Scanner;
/**
 * Lab01_1
 */
public class Lab01_1 {


    private static void printSolution(int x, int y, int c){
        int z;
        
        if (x > y){
            z = x;
            x = y;
            y = z;
        }
        System.out.printf("%d %d", x, y);
        
        int count = 2;
        while ((z = 2 * x + y + 1) <= c){
            ++ count;
            x = y;
            y = z;
            System.out.printf(" %d", z);
        }
        
        System.out.printf("\n%d\n", count);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.print("Enter A: ");
        int a = sc.nextInt();
        //System.out.print("Enter B: ");
        int b = sc.nextInt();
        //System.out.print("Enter C: ");
        int c = sc.nextInt();

        printSolution(a, b, c);
    }
    
}
