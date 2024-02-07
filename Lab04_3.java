//660510657
//Tharachon Warintaweewat
import java.util.ArrayList;
import java.util.Scanner;


public class Lab04_3 {
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = 1;
        Score score = new Score();
        while(true) {
            input = sc.nextInt();
            if (input == 0){
                break;
            }
            if (input > 100||input<0) {
                continue;
            }
            score.setdata(input);
        }
        int max = score.findMax();
        int min = score.findMin();
        System.out.println(max+" "+score.getposition(max));
        System.out.println(min+" "+score.getposition(min));
        System.out.println(score.countAver());
        sc.close();
    }
}
class Score{
        private ArrayList<Integer> data = new ArrayList<Integer>();
        private int max;
        private int min;
        private int cout;
        private float aver;
        private int sum;
        private float total;
        
        public void setdata(int n){
            this.data.add(n);
        }
    
        public int findMax(){
            this.max = 0;
            for (int i:data){
                if(i>this.max){
                    this.max = i;
                }
            }
            return this.max;
        }

        public int findMin(){
            this.min=0;
            for (int i:data){
                if(i<this.min||this.min==0){
                    this.min = i;
                }
            }
            return this.min;
        }

        public int countAver(){
            this.sum = 0;
            for (int i:data){
                this.sum += i;
                }
            this.total = data.size();
            this.aver = this.sum/this.total;
            for (int i:data){
                if (i<aver) {
                    cout += 1;
                }
            }
            return this.cout;
        }
        
        public int getposition(int n){
            return data.indexOf(n)+1;
        }
        public ArrayList<Integer> getdata(){
            return data;
        }
        public float getaver(){
            return aver;
        }
        
    }