/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//package lab02_1;

/**
 *
 * @author CSB_Lab
 */
import java.util.Scanner;
public class Lab02_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        char mode = sc.next().charAt(0);
        String symb = sc.next();
        int n = sc.nextInt();
        // check if the ASCII of mode is the little case
        if (mode >= 'a'&& mode <= 'z')
            printStartDown(n, symb);
        // check if the ASCII of mode is the big case
        else if (mode >= 'A' && mode <= 'Z')
            printStartUp(n, symb);
        // otherwise
        else
            printStartBoth(n, symb);
    }
    
    private static void printStartDown(int n,String symb){
        for (int i = 0; i <= n-1; ++i){
            for (int j = 0; j < n-i; ++j){
                System.out.print(symb);
            }
            System.out.println();
        }
    }
        
    private static void printStartUp(int n,String symb){
        for (int i = 1; i <= n; ++i){
            for (int j = 0; j < n-i; ++j){
                System.out.print(" ");
            }
            for (int j = n-i; j < n; ++j){
                System.out.print(symb);
            }
            System.out.println();
        }
    }
    private static void printStartBoth(int n,String symb){
        printStartUp(n, symb);
        printStartDown(n-1, symb);
    }
    
}
