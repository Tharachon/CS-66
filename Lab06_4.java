//660510657
//Tharachon Warintaweewat

import java.util.Scanner;

/**
 * Lab06_4
 */
public class Lab06_4 {
    public static void process(Customer[] cus, Transaction[] tran){
        for (int i = 0; i < tran.length; i++) {
            char type = tran[i].getType();
            switch (type) {
                case 'D':
                    for (int j = 0; j < cus.length; j++) {
                        if (cus[j].getCode().equals(tran[i].getCode1())){
                            cus[j].setBalanceD(tran[i].getMoney());
                        }
                    }
                    break;
                case 'W':
                    for (int j = 0; j < cus.length; j++) {
                        if (cus[j].getCode().equals(tran[i].getCode1())){
                            if (cus[j].getBalnce()-tran[i].getMoney() >= 100){
                                cus[j].setBalanceW(tran[i].getMoney());
                            }
                            
                        }
                    }
                    break;
                case 'T':
                    for (int j = 0; j < cus.length; j++) {
                        if (cus[j].getCode().equals(tran[i].getCode1())){
                            if (cus[j].getBalnce()-tran[i].getMoney() >= 100){
                                cus[j].setBalanceW(tran[i].getMoney());
                                for (int k = 0; k < cus.length; k++) {
                                    if (cus[k].getCode().equals(tran[i].getCode2())){
                                        cus[k].setBalanceD(tran[i].getMoney());
                                    }
                                }
                            }
                        }
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        Customer[] customer = new Customer[m];
        Transaction[] transactions = new Transaction[n];
        for (int i = 0; i < m; i++) {
            customer[i] = new Customer(sc.next(), sc.next(), sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            char t = sc.next().charAt(0);
            if (t != 'T' ){
                transactions[i] = new Transaction(t, sc.next(), sc.nextInt());
            }else{
                transactions[i] = new Transaction(t, sc.next(), sc.next(), sc.nextInt());
            }
        }
        process(customer,transactions);

        for (int i = 0; i < customer.length; i++) {
            System.out.print(customer[i].getCode() + " ");
            System.out.print(customer[i].getName() + " ");
            System.out.print(customer[i].getBalnce()+ " ");
            System.out.println();
        }
        sc.close();
    }
}

class Customer{
    private String code;
    private String name;
    private int balance;

    public Customer(String c, String n, int b){
        this.code = c;
        this.name = n;
        this.balance = b;
    }

    public String getCode(){
        return code;
    }
    public String getName(){
        return name;
    }
    public int getBalnce(){
        return balance;
    }

    public void setBalanceD(int n){
        this.balance += n;
    }
    public void setBalanceW(int n){
        this.balance -= n;
    }

}
class Transaction{
    private char type;
    private String code1;
    private String code2;
    private int money;

    public Transaction(char t, String c1, String c2, int m){
        this.type = t;
        this.code1 = c1;
        this.code2 = c2;
        this.money = m;
    }
    public Transaction(char t, String c1, int m){
        this.type = t;
        this.code1 = c1;
        this.money = m;
    }
    public char getType(){
        return type;
    }
    public String getCode1(){
        return code1;
    }
    public String getCode2(){
        return code2;
    }
    public int getMoney(){
        return money;
    }
}