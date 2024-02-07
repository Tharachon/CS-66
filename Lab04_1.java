// 660510657
// Tharachon Warintaweewat
import java.util.Scanner;
class Matrix{
    private int size;
    private int[][] matrix;

    // other properties of the matrix
    // based on whether some of the elements were filled with non-zero
    private boolean diagonal = false;
    private boolean diagOne = false;
    private boolean upperTri = false;
    private boolean lowerTri = false;

    public void determineMatrix(){
        int i, j;
        this.diagonal = false;
        this.diagOne = false;
        this.upperTri = false;
        this.lowerTri = false;

        // check diagonal
        for(i = 0; i < this.size; ++i){
            this.diagOne = true;
            if(this.matrix[i][i] != 0){
                this.diagonal = true;
                this.diagOne = diagOne && matrix[i][i] == 1;
            }
        }

        // check upper triangular
        for(i = 0; i < this.size - 1; ++i){
            if(this.upperTri)
                break;

            for(j = i + 1; j < this.size; ++j){
                if(this.matrix[i][j] != 0){
                    this.upperTri = true;
                    break;
                }
            }
        }

        // check lower triangular
        for(i = 1; i < this.size; ++i){
            if(this.lowerTri)
                break;

            for(j = 0; j < i; ++j){
                if(this.matrix[i][j] != 0){
                    this.lowerTri = true;
                    break;
                }
            }
        }
    }
    public Matrix(int n){
        this.size = n;
        this.matrix = new int[n][n];
    }
    public void setData(int i, int j, int data){
        matrix[i][j] = data;
    }
    public String getType(){

        if(this.diagOne && !this.upperTri && !this.lowerTri)
            return "I";

        if(this.upperTri && this.diagonal && !this.lowerTri)
            return "U";

        if(this.lowerTri && this.diagonal && !this.upperTri)
            return "L";

        return "O";
    }
}

public class Lab04_1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Matrix matrix = new Matrix(n);

        int i, j;
        for(i = 0; i < n; ++i){
            for(j = 0; j < n; ++j){
                matrix.setData(i, j, sc.nextInt());
            }
        }

        matrix.determineMatrix();
        System.out.println(matrix.getType());
    }
}