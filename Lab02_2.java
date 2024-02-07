//660510657
//Tharachon Warintaweewat

import java.util.Scanner;
/**
 * Lab02_2
 */
public class Lab02_2 {

    private static void checkOddEven(int num){
        if (num%2 == 0)
            System.out.println("even");
        else
            System.out.println("odd");
    }


    private static void checkPrime(int num){
        int temp=0;      
        int m = num/2;      
        if(num == 0 || num == 1){  
         System.out.println("not prime");      
        }
        else{  
            for(int i=2; i<=m; i++){      
                if(num%i == 0){      
                    System.out.println("not prime");      
                    temp = 1;      
                    break;      
                }      
            }      
            if(temp == 0)  {
                System.out.println("prime");
            }  
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        checkOddEven(num);
        checkPrime(num);
    }
}
