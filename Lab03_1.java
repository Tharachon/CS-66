//660510657
//Tharachon Warintaweewat
import java.util.Scanner;

/**
 * Lab03_1
 */
public class Lab03_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char sex = sc.next().charAt(0);
        float weight = Float.parseFloat(sc.next());
        int height = sc.nextInt();

        //create a person instance
        Person person = new Person();
        person.setSex(sex);
        person.setHeight(height);
        person.setWeight(weight);


        if(person.getSex() == 'm'){
            System.out.print("Male ");
        }else{
            System.out.print("Female ");
        }

        if (person.isShapeOK()){
            System.out.println("OK");
        }else{
            System.out.println("not OK");
        }
    }
}

class Person{
    private char sex;
    private float weight;
    private int height;

    public boolean isShapeOK(){
        if (sex == 'm'){
            return weight <=  height - 100;
        }else{
            return weight <= height - 110;
        }
    }

    public void setSex(char sex){
        //convert a charactor to lowercase
        this.sex = Character.toLowerCase(sex);
    }
    public void setWeight(float weight){
        this.weight = weight;
    }
    public void setHeight(int height){
        this.height = height;
    }
    

    public char getSex(){
        return sex;
    }
    public int getHeight(){
        return height;
    }
    public float getWeight(){
        return weight;
    }
}