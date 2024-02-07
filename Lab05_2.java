//660510657
//Tharachon Warintaweewat
import java.util.Scanner;

/**
 * Lab05_2
 */
public class Lab05_2 {
    public static void compareWeightbase(Person p1, Person p2){ 
        int diff1 = Math.abs(p1.getWeight()-p1.getStandardWeight());
        int diff2 = Math.abs(p2.getWeight()-p2.getStandardWeight());
        if (diff1 == diff2)
            System.out.println("both");
        else 
            if (diff1 < diff2) 
                System.out.println(p1.getName());
            else
                System.out.println(p2.getName());
    } //end of method compareWeightbase()
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String s = input.next().trim();
        Person p1 = new Person(s);              

        char sex = input.next().charAt(0);
        int H = input.nextInt();
        int W = input.nextInt();


        p1.setInfo(sex, H, W);  
        p1.setStandardWeight();

        s = input.next().trim();
        sex = input.next().charAt(0);

        Person p2 = new Person(s, sex, input.nextInt(), input.nextInt());
        p2.setStandardWeight();
        compareWeightbase(p1, p2);              
        
        
        input.close();
    } //end method main()
} //end class Lab05_2

class Person{
    private String name;
    private int height;
    private int weight;
    private char sex;
    private int standardWeight;

    public Person(String s){
        this.name = s;
    }
    public Person(String s, char sex, int height, int weight){
        this.name = s;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
    }
    public String getName(){
        return this.name;
    }
    public int getWeight(){
        return this.weight;
    }
    public int getStandardWeight(){
        return this.standardWeight;
    }

    public void setInfo(char sex, int h, int w){
        this.sex = sex;
        this.height = h;
        this.weight = w;
    }

    public void setStandardWeight(){
        if (this.sex == 'M')
            this.standardWeight = this.height - 100;
        else
            this.standardWeight = this.height - 110;
    }
}