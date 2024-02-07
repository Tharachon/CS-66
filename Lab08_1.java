/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//Tharachon Warintaweewat
//660510657

import java.util.*;

//package Lab08_1;

/**
 *
 * @author CSB_Lab
 */
public class Lab08_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        
        String OrderID = input.next();
        String TableNO = input.next();
        int N = input.nextInt();
        
        //create a corresponding Order instance
        Order order = new Order();
        order.setData(OrderID, TableNO, (byte)N);
        
        for(int i=0; i<N; i++){
            
            // insert an order item
            String foodName = input.next();
            short price = (short)input.nextInt();
            byte numDish = (byte)input.nextInt();
            
            OrderItem item = new OrderItem();
            item.setData(foodName, price, numDish);
            item.calTotalPrice();
            order.setData(item);
            // insert code here to initiate new orderItem and add to order

        }
        
        // insert code here for summary after all input
        order.calOverAllPrice();
        order.showData();
        
        input.close();
    }
    
}

class Order{
    // data member
    private String orderId;
    private String tableNo;
    private int OverAllPrice = 0;
    private byte N = 0; //number of order item
    // data member to keep a list of orderItems
    private ArrayList <OrderItem> orderItems = new ArrayList<OrderItem>();
    
    // methods
    public void setData(String s1, String s2, byte b1){
        this.orderId = s1;
        this.tableNo = s2;
        this.N = b1;
    }
    public void setData(OrderItem i1){
        this.orderItems.add(i1);
    }
    public void showData(){
        System.out.println(orderId + " " + tableNo);
        int no=1;
        for(OrderItem i: orderItems){
            System.out.print(no++ + ") ");
            i.showData();
            System.out.println();
        }
        System.out.println(OverAllPrice);
    }
    public void calOverAllPrice(){
        for (OrderItem i: orderItems){
            this.OverAllPrice += i.getTotalPrice();
        }
    }
    
    
}

class OrderItem {
    // attributes
    private String foodName;
    private short price;
    private byte numDish;
    private int totalPrice;
    
    // methods
    public void setData(String s1, short sh1, byte b1){
        this.foodName = s1;
        this.price = sh1;
        this.numDish = b1;
        calTotalPrice();
    }
    
    public void calTotalPrice(){
        this.totalPrice = (int)(this.numDish * this.price);
    }
    
    public void showData(){
        System.out.print(this.foodName + " = " + this.price + " x " + this.numDish + " = " + this.totalPrice);
    }
    
    public int getTotalPrice(){
        return this.totalPrice;
    }
}