//660510657
//Tharachon Warintaweewat
import java.util.Scanner;

/**
 * Lab06_1
 */
public class Lab06_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char X = sc.next().charAt(0);
        char type = sc.next().charAt(0);
        Triangle myTriangle = new Triangle(N);
        myTriangle.draw();
        myTriangle.draw(X);
        myTriangle.draw(X,type);
        sc.close();
    }
}

class Triangle{
    private int size;

    public Triangle(int N){
        this.size = N;
    }
    public void draw(){
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < i+1;j++) {
                System.out.print('*');   
            }
            System.out.println();
        }
    }
    public void draw(char x){
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < i+1;j++) {
                System.out.print(x);   
            }
            System.out.println();
        }
    }

    public void draw(char x, char type){
        if (type == 'R') {
            for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < this.size-i-1; j++) {
                    System.out.print(' ');
                }
                for (int j = 0; j < i+1;j++) {
                    System.out.print(x);   
                }
                System.out.println();
            }
        }else{
            for (int i = 0; i < this.size; i++) {
                
                for (int j = 0; j < this.size - i; j++) {
                    System.out.print(x);  
                }
                System.out.println();
            }
        }
        
    }

}