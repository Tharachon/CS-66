//660510657
//Tharachon Warintaweewat

import java.util.Scanner;

/**
 * Lab05_3
 */
public class Lab05_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Stack box = new Stack(n);
        int operate;
        do {
            operate = sc.nextInt();
            switch (operate) {
                case 1:box.push(sc.nextInt());
                        break;
                case 2:box.pop();
                        break;
                case 3:box.getTop();
                        break;
                case 4:System.out.println(box.getSize());
                        break;
                case 5:box.show();
            }

        } while (operate != 6);

        sc.close();
    }
}
class Stack{
    private int meaxSiz;
    private int[] item;
    private int top = -1;

    public Stack(int n){ //constructor
        this.maxSize = n;
        this.item = new int[n];
    }

    private boolean isFull(){
        return (this.maxSize == top+1);
    }

    private boolean isEmpty(){
        return (this.top < 0);
    }

    public void show(){
        if (!isEmpty()) {
            for (int i = 0; i <= this.top; i++) 
                System.out.print(item[i] + " ");                
            System.out.println();
        }
        else
            System.out.println("empty");
    }

    public void push(int x){
        if (isFull()){
            System.out.println("full");
        }
        else{
            this.top += 1;
            this.item[this.top] = x;
        }
    }

    public void pop(){
        if (isEmpty()) 
            System.out.println("empty");
        else{
            System.out.println("pop" +" " + item[top]);
            this.top -= 1;
        }
        
        
    }

    public void getTop(){
        if (isEmpty()) {
            System.out.println("empty");
        }else
        System.out.println(item[this.top]);
    }

    public int getSize(){
        return top+1;
    }

    
}
