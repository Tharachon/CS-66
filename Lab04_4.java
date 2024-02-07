//660510657
//Tharachon Warintaweewat

import java.util.Scanner;

public class Lab04_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        caesarCipher caesar = new caesarCipher();
        caesar.setStr(sc.nextLine());
        caesar.ship();
        sc.close();
    }
}

class caesarCipher{
    private String str;

    public void setStr(String data){
        this.str = data;
    }

    public void ship(){
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            int x =((char)str.charAt(i)+3);
            if(x>122){
                x -= 26;
            }
            System.out.print(Character.toUpperCase((char)x));
            if (j == 2){
                j = 0;
                System.out.print(" ");
                continue;
            }
            j++;
        }
        if (j != 0){
            for (int k = 0; k <3-j; k++) {
                System.out.print('#');
            }
        }
    }
    public String getString(){
        return str;
    }
}