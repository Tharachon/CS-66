//660510657
//Tharachon Warintaweewat
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Lab05_1
 */
public class Lab05_1 {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.0");
        Scanner sc = new Scanner(System.in);
        Bottle bottle1 = new Bottle("Size02",2,6);
        bottle1.calVolume();
        System.out.print(bottle1.getName() + " ");
        System.out.print(df.format(bottle1.getVolume()));
        System.out.println();

        Bottle bottle2 = new Bottle();
        bottle2.setData(sc.next(),Double.valueOf(sc.next()),Double.valueOf(sc.next()));
        bottle2.calVolume();
        System.out.print(bottle2.getName() + " ");
        System.out.print(df.format(bottle2.getVolume()));
        System.out.println();
        sc.close();
    }
}

class Bottle{
    private String name;
    private double radius;
    private double height;
    private double volume;


    public Bottle(String name,double rad,double hei){
        this.name = name;
        this.radius = rad;
        this.height = hei;
        System.out.println("1st constructor");
    }

    public Bottle(){
        System.out.println("2nd constructor");
    }

    public void setData(String name,double rad,double hei){
        this.name = name;
        this.radius = rad;
        this.height = hei;
    }

    public void calVolume(){
        this.volume =  Math.PI*Math.pow(this.radius,2)*this.height;
    }
    
    public double getRadius(){
        return radius;
    }
    public double getHeight(){
        return height;
    }
    public String getName(){
        return name;
    }
    public double getVolume(){
        return volume;
    }
}