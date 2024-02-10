/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//package lab09_1;

import java.util.Scanner;

/**
 *
 * @author CSB_Lab
 */
public class Lab09_2 {

    /**
     * @param args the command line arguments
     */
    
    public static void show1(Shape2Dim[] obj, int M){
        for(int i=0;i<M;i++){
            obj[i].draw();
        }
    }
    
    public static void show2(Shape2Dim[] obj, int M){
        System.out.println("Rhombus");
        for(int i=0;i<M;i++){
            if (obj[i] instanceof Rhombus)
                obj[i].draw();
        }
        System.out.println("Square");
        for(int i=0;i<M;i++){
            if (obj[i] instanceof Square)
                obj[i].draw();
        }
        System.out.println("Triangle");
        for(int i=0;i<M;i++){
            if (obj[i] instanceof Triangle)
                obj[i].draw();
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int M, N, i;
        int num;
        char symbol = input.next().charAt(0);
        char type;
        M = input.nextInt();
        
        Shape2Dim[] obj = new Shape2Dim[M];
        
        for(i=0; i<M;i++){
            type = input.next().charAt(0);
            num = input.nextInt();
            switch (type){
                case 'R':
                    obj[i] = new Rhombus(num, symbol);
                    break;
                case 'S':
                    obj[i] = new Square(num, symbol);
                    break;
                case 'T':
                    obj[i] = new Triangle(num, symbol);
            }
        }
        
        int show_type = input.nextInt();
        
        if(show_type == 1)
            show1(obj, M);
        else
            show2(obj, M);
        
        
        input.close();
    }
    
}
abstract class Shape2Dim{
    protected int N=0;
    protected char symbol = '#';
    public abstract void draw();
}

class Rhombus extends Shape2Dim{
    public Rhombus(int i1, char ch1){
        super.N = i1;
        super.symbol = ch1;
    }
    
    public void draw(){
        
        if(N>0){
            int i;
            
            String fsq = "%" + N + "c\n";
            String fsq2;
            System.out.printf(fsq, symbol);
            
            for (i=1; i<N; i++){
                fsq2 = "%" + (N-i) + "c%" + (2*i) + "c\n";
                System.out.printf(fsq2, symbol, symbol);
            }
            
            for (i = N-2; i>=1; i--){
                fsq2 = "%"+(N-i)+"c%"+(2*i)+"c\n";
                System.out.printf(fsq2, symbol, symbol);
            }
            
            System.out.printf(fsq, symbol);
        }
    }
}

class Triangle extends Shape2Dim{
    public Triangle(int i1, char ch1){
        super.N = i1;
        super.symbol = ch1;
        
    }
    public void draw(){
        
        if(N>0){
            int i;
            
            String fsq = "%" + N + "c\n";
            String fsq2;
            System.out.printf(fsq, symbol);
            
            for (i=1; i<N-1; i++){
                fsq2 = "%" + (N-i) + "c%" + (2*i) + "c\n";
                System.out.printf(fsq2, symbol, symbol);
            }
            
            for (i=0; i<(2*N)-1; i++){
                System.out.print(symbol);
            }
            System.out.println();
            
        }
    }
}
class Square extends Shape2Dim{
    public Square(int i1, char ch1){
        super.N = i1;
        super.symbol = ch1;
    }
    public void draw(){
        
        if(N>0){
            int i;
            
            String fsq2;
            
            for (i=0; i<N; i++){
                System.out.print(symbol);
            }
            System.out.println();
            
            for (i=1; i<N-1; i++){
                fsq2 = "%" + 1 + "c%" + (N-1) + "c\n";
                System.out.printf(fsq2, symbol, symbol);
            }
            
            for (i=0; i<N; i++){
                System.out.print(symbol);
            }
            System.out.println();
            
        }
    }
}