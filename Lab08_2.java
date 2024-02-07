/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//Tharachon Warinatweewat
//660510657

import java.util.ArrayList;
import java.util.Scanner;

//package lab08_2;

/**
 *
 * @author CSB_Lab
 */
public class Lab08_2 {
    private static Scanner input = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    
    public static short findPrice(Food [] foodList, String foodName){
        for(Food i:foodList){
            if (i.foodName.equals(foodName))
                return i.price;
        }
        return 0;
    }
    
    public static void calTotalPricePerFood(Food [] foodList, String foodName, int TotalItemPrice){
        for(Food i:foodList){
            if (i.foodName.equals(foodName))
                i.calTotalSale(TotalItemPrice);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int i, M = input.nextInt();
        Food [] foodList = new Food[M];
        
        for(i=0; i<M; i++){
            foodList[i] = new Food();
            foodList[i].setData(input.next(), (short)input.nextInt());
        }
        
        int k, K = input.nextInt(), allSale = 0;
        Order [] orderList = new Order[K];
        for (k=0; k<K; k++){
            String orderId = input.next();
            String tableNo = input.next();
            int N = input.nextInt();
            orderList[k] = new Order();
            orderList[k].setData(orderId, tableNo, N);
            for (int j=0; j<N; j++){
                OrderItem item = new OrderItem();
                String foodName = input.next();
                item.setData(foodName, findPrice(foodList, foodName), (byte)input.nextInt());
                calTotalPricePerFood(foodList, foodName, item.getTotalPrice());
                orderList[k].setData(item);
            }
            orderList[k].calTotalPrice();
            allSale += orderList[k].getTotalPrice();

            orderList[k].showTotal();
        }
               
        for(i=0; i<M; i++){
            System.out.println(foodList[i].foodName + " " + foodList[i].totalSale);
        }
        System.out.println(allSale);
        input.close();
    }
    
}
class Order{
    // data member
    private String orderId;
    private String tableNo;
    private int totalPrice = 0;
    private int N = 0; //number of order item
    // data member to keep a list of orderItems
    private ArrayList <OrderItem> orderItems = new ArrayList<OrderItem>();
    
    // methods
    public void setData(String s1, String s2, int b1){
        this.orderId = s1;
        this.tableNo = s2;
        this.N = b1;
    }
    public void setData(OrderItem i1){
        this.orderItems.add(i1);
    }
    
    public void calTotalPrice(){

        
        for(OrderItem i: this.orderItems){
            // System.out.println(i.getData() + " " + i.getTotalPrice() + " ");
            this.totalPrice += i.getTotalPrice();
            // System.out.println(this.totalPrice);
        }
    }

    public void showData(){
        for(OrderItem i: this.orderItems){
            System.out.println(i.getData() + " " + i.getTotalPrice());
        }
    }
    
    public void showTotal(){
        System.out.printf("%s %s %d\n", this.orderId, this.tableNo, this.totalPrice);
    }

    public int getTotalPrice(){
        return this.totalPrice;
    }
}

class OrderItem {
    // attributes
    private Food food = new Food();
    private byte numDish;
    private int totalPrice;
    
    // methods
    public void setData(String s1, short sh1, byte b1){
        this.food.setData(s1, sh1);
        this.numDish = b1;
        this.calTotalPrice();
    }
    
    public void calTotalPrice(){
        this.totalPrice = (int)(this.numDish * food.price);
    }


    public String getData(){
        return this.food.foodName;
    }
    public int getTotalPrice(){
        return this.totalPrice;
    }
}

class Food {
    String foodName;
    short price;
    int totalSale = 0;
    
    public void setData(String i1, short s1){
        this.foodName = i1;
        this.price = s1;
    }
    
    public void calTotalSale(int i1){
        this.totalSale += i1;
    }

    public String getFoodName(){
        return this.foodName;
    }
    
}