//660510657
//Tharachon Warintaweewat

import java.util.Scanner;


/**
 * Lab02_3
 */
public class Lab02_3 {
    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        int[] dataPoint = new int[4];
        for (int i=0; i<4; i++){
            dataPoint[i] = get.nextInt();
        }
        int count = get.nextInt();
        int[] status = new int[count];
        for (int i=0; i<count; i++){
            int a, b;
            a = get.nextInt();
            b = get.nextInt();
            status[i] = checkboundary(dataPoint,a,b);    
        }
        
        for (int i=1; i<4; i++){
            int temp=0;
            for(int j: status){
                if (j == i){
                    temp += 1;
                }
            }
            System.out.print(temp + " ");
        }
    }

    private static int checkboundary(int[] square, int a, int b){
        int x1,y1,x2,y2;
        if (square[0] > square[2]){
            x1 = square[2];
            x2 = square[0];
        }else{
            x1 = square[0];
            x2 = square[2];
        }
        if (square[1] < square[3]){
            y1 = square[3];
            y2 = square[1];
        }else{
            y1 = square[1];
            y2 = square[3];
        }

        if ((a<x1||a>x2)||(b>y1||b<y2)){
            return 3;
        }
        else if(a==x1||a==x2||b==y1||b==y2){
            return 2;
        }else{
            return 1;
        }
    }
}
