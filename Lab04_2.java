// 660510657
// Tharachon Warintaweewat
import java.util.Scanner;

class Matrix{
    private int size;
    private int[][] matrix;
    private int cout = 0;

    // private boolean isTripleNumber = false;

    public void tripleNumber(){
        int i, j;

        for(i=0;i<size;i++){
            for(j=0;j<size;j++){
                if (i == 0 || i == size-1 || j == 0 || j == size-1) {
                    checkTripleNumber(matrix[i][j]);
                    // cout += 1;
                }else if (i==j) {
                    checkTripleNumber(matrix[i][j]);
                    // cout += 1;
                }else if (i == size-j-1){
                    checkTripleNumber(matrix[i][j]);
                    // cout += 1;
                }
            }
        }
        if (this.cout == 0){
            System.out.println("No");
        }
    }

    public void checkTripleNumber(int number){
        if (number>=100 && number<1000 && number!=0 && number%111==0){
            System.out.print(number + " ");
            this.cout += 1;
        }
        
    }

    public Matrix(int n){
        this.size = n;
        this.matrix = new int[n][n];
    }
    public void setData(int i, int j, int data){
        matrix[i][j] = data;
    }

}
public class Lab04_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Matrix matrix = new Matrix(n);

        int i, j;
        for(i=0;i<n;++i){
            for(j=0;j<n;++j){
                matrix.setData(i, j, sc.nextInt());
            }
        }
        matrix.tripleNumber();

    }
}