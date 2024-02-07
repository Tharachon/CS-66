//660510657
//Tharachon Warintaweewat
import java.util.Scanner;

public class Lab06_5 {

    public static void checkAndPrintVote(Star[] starM ,Star[] starF){
        int maxM = 0, maxF = 0;
        for (Star i: starM){
            if (i.getVote() > maxM)
                maxM = i.getVote();
            
        }
        for (Star i: starF){
            if (i.getVote() > maxF)
                maxF = i.getVote();
            
        }
        
        for (Star i: starM){
            if (i.getVote() == maxM)
                System.out.print(i.getName() + " ");
            
        }
        for (Star i: starF){
            if (i.getVote() == maxF)
                System.out.print(i.getName() + " ");
            
        }
        System.out.println();
    }
    
    public static void printGoodLuckPeople(Voter[] voter , Star[] starM ,Star[] starF){
        int maxM = 0, maxF = 0;
        char starMNo = '0', starFNo = '0';
        for (Star i: starM){
            if (i.getVote() > maxM){
                maxM = i.getVote();
            }
        }
        for (Star i: starF){
            if (i.getVote() > maxF){
                maxF = i.getVote();
            }
        }
        
        for (Star i: starM){
            if (i.getVote() == maxM){
                starMNo = i.getNumber();
            }
        }
        for (Star i: starF){
            if (i.getVote() == maxF){
                starFNo = i.getNumber();
            }
        }
       for (Voter i: voter){
           if((i.getMaleNo() == starMNo) && (i.getFemaleNo() == starFNo)){
               System.out.print(i.getName() + " ");
           }
       }
       System.out.println();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Star[] starM = new Star[3];
        Star[] starF = new Star[3];
        starM[0] = new Star('1',"Nadech");
        starM[1] = new Star('2',"Wier");
        starM[2] = new Star('3',"Mario");
        starF[0] = new Star('1',"Aum");
        starF[1] = new Star('2',"Yaya");
        starF[2] = new Star('3',"Bella");
        
        
        int n = input.nextInt();
        Voter[] voter = new Voter[n];
        for (int i=0;i<n;i++){
            String name = input.next();
            char maleNo = input.next().charAt(0);
            char femaleNo = input.next().charAt(0);
            voter[i] = new Voter(name, maleNo, femaleNo);
        }
        
        for (int i=0; i<voter.length;i++){
            for (int j=0;j<starM.length;j++){
                if (starM[j].getNumber() == voter[i].getMaleNo())
                    starM[j].setVote();
            }
            for (int j=0;j<starF.length;j++){
                if (starF[j].getNumber() == voter[i].getFemaleNo())
                    starF[j].setVote();
            }
        }
        checkAndPrintVote(starM, starF);
        printGoodLuckPeople(voter, starM, starF);
        
        
//        System.out.println(starM[1].getVote());
//        System.out.println(starF[1].getVote());
        input.close();
    }
    
}
class Star{
    private char number;
    private String name;
    private int vote;
    
    //constructor
    public Star(char number, String name){
        this.number = number;
        this.name = name;
        this.vote = 0;
    }
    
    // set Method
    public void setVote(){
        this.vote += 1;
    }
    
    // get Method
    public char getNumber(){
        return this.number;
    }
    public String getName(){
        return this.name;
    }
    public int getVote(){
        return this.vote;
    }
    
}// end class

class Voter{
    private String name;
    private char maleNo;
    private char femaleNo;
    
    // constructor
    public Voter(String name, char maleNo, char femaleNo){
        this.name = name;
        this.maleNo = maleNo;
        this.femaleNo = femaleNo;
    }
    
    //get Method
    public String getName(){
        return this.name;
    }
    public char getMaleNo(){
        return this.maleNo;
    }
    public char getFemaleNo(){
        return this.femaleNo;
    }
}
