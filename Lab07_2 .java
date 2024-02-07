/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//package lab07_2;

import java.util.Scanner;
import java.text.DecimalFormat;

/**
 *
 * @author CSB_Lab
 */
public class Lab07_2 {
    
    
    public static Scanner input = new Scanner(System.in);
    public static DecimalFormat df = new DecimalFormat("0.00");
    
    public static void printMonth(MonthlyEmployee empMonth [], int N){
        int i, salary, OT, total;
        String id, name;
        int sumSalary = 0, sumOverTime = 0, Total = 0;
        for(i = 0;i < N;i++){
            
            id = empMonth[i].getID();
            name = empMonth[i].getName();
            salary = empMonth[i].getSalary();
            OT = empMonth[i].getOverTimeWage();
            total = (int)empMonth[i].getTotal();
            sumSalary += salary;
            sumOverTime += OT;
            Total += total;
            System.out.println(id + "," + name + "," + salary + "," + OT + "," + total);
        }
        System.out.println(sumSalary + "," + sumOverTime + "," + Total);
    }
    public static void printWeek(WeeklyEmployee empWeek [], int N){
        int i, Monthly;
        float commission, total, sumCommission = 0,  Total = 0;
        String id,name;
        int sumMonthlyWage = 0;
        for(i = 0;i < N;i++){
            
            id = empWeek[i].getID();
            name = empWeek[i].getName();
            commission = empWeek[i].getCommission();
            Monthly = empWeek[i].getMonthlyWage();
            total = empWeek[i].getTotal();
            sumCommission += commission;
            sumMonthlyWage += Monthly;
            Total += total;
            System.out.println(id + "," + name + "," + df.format(commission) + "," + Monthly + "," + df.format(total));
        }
        
        System.out.println(df.format(sumCommission) + "," + sumMonthlyWage + "," + df.format(Total));
        
        
    }
    
    public static void printDaily(DailyEmployee empDay[], int N){
        int i, Monthly;
        float commission, total, sumCommission = 0,  Total = 0;
        String id,name;
        int sumMonthlyWage = 0;
        for(i = 0;i < N;i++){
            
            id = empDay[i].getID();
            name = empDay[i].getName();
            commission = empDay[i].getCommission();
            Monthly = empDay[i].getMonthlyWage();
            total = empDay[i].getTotal();
            sumCommission += commission;
            sumMonthlyWage += Monthly;
            Total += total;
            System.out.println(id + "," + name + "," + df.format(commission) + "," + Monthly + "," + df.format(total));
        }
        
        System.out.println(df.format(sumCommission) + "," + sumMonthlyWage + "," + df.format(Total));
    }
    
    public static void handleEmpMonth(MonthlyEmployee empMonth [], int N){
        int i;
        for(i = 0;i < N;i++){
            
            empMonth[i] = new MonthlyEmployee();
            empMonth[i].setID(input.next());
            empMonth[i].setName(input.next());
            empMonth[i].setSalary(input.nextInt());
            empMonth[i].setOverTimePeriod(input.nextInt());
            empMonth[i].calAndSetOverTimeWage();
            empMonth[i].setTotal();
        }
        
        
        
    }
    
    
    public static void handleEmpWeek(WeeklyEmployee empWeek [], int N){
        int i;
        for(i = 0;i < N;i++){
            
            empWeek[i] = new WeeklyEmployee();
            empWeek[i].setID(input.next());
            empWeek[i].setName(input.next());
            empWeek[i].setTotalSale(input.nextInt());
            empWeek[i].setPercentCommRate(input.nextInt());
            empWeek[i].setWeeklyRate(input.nextInt());
            empWeek[i].setWorkingWeek(input.nextInt());
            empWeek[i].calAndSetCommission();
            empWeek[i].calAndSetMonthlyWage();
            empWeek[i].setTotal();
        }
        
    }
    
    public static void handleEmpDay(DailyEmployee empDay [], int N){
        int i;
        for(i = 0;i < N;i++){
            
            empDay[i] = new DailyEmployee();
            empDay[i].setID(input.next());
            empDay[i].setName(input.next());
            empDay[i].setTotalSale(input.nextInt());
            empDay[i].setPercentCommRate(input.nextInt());
            empDay[i].calAndSetCommission();
            empDay[i].setDailyRate(input.nextInt());
            empDay[i].setWorkingDay(input.nextInt());
            empDay[i].calAndSetMonthlyWage();
            empDay[i].setTotal();
        }
        
    }

    public static void main(String[] args) {
        MonthlyEmployee [] empMonth;
        WeeklyEmployee [] empWeek;
        DailyEmployee [] empDay;
        int M = input.nextInt(); // number of monthly employees
        if(M>0){
            empMonth = new MonthlyEmployee[M];
            handleEmpMonth(empMonth, M);
        }
        int N = input.nextInt(); //number of weekly employees
        if(N>0){
            empWeek = new WeeklyEmployee[N];
            handleEmpWeek(empWeek, N);
        }
        int O = input.nextInt(); //number of daily employees
        if(O>0){
            empDay = new DailyEmployee[O];
            handleEmpDay(empDay, O);
        }
        if(M>0){
            printMonth(empMonth,M);
        }
        if(N>0){
            printWeek(empWeek,N);
        }
        if(O>0){
            printDaily(empDay, O);
        }
        //insert code here
    }
    
}

class Employee{
    protected String id;
    protected String name;
    protected float total;
    
    public void setID(String s1){
        this.id = s1;
    }
    public void setName(String s2){
        this.name = s2;
    }
    
    
    public String getID(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public float getTotal(){
        return this.total;
    }
    //insert code here
}

class CommissionEmployee extends Employee{
    protected float totalSale;
    protected int percentCommRate;
    protected float commission;
    protected int monthlyWage;
    
    public void setTotalSale(int i1){
        this.totalSale = (float)i1;
    }
    public void setPercentCommRate(int i2){
        this.percentCommRate = i2;
    }
    
    public void calAndSetCommission(){
        this.commission = (float)(this.totalSale * this.percentCommRate/100); 
    }
    
    public void setTotal(){
        super.total = (float) this.commission + this.monthlyWage;
    }
    
    public float getCommission(){
        return this.commission;
    }
    public int getMonthlyWage(){
        return this.monthlyWage;
    }
}

class MonthlyEmployee extends Employee{
    private int salary;
    private int overTimePeriod;
    private int overTimeWage;
    
    public void setSalary(int i1){
        this.salary = i1;
    }
    public void setOverTimePeriod(int i2){
        this.overTimePeriod = i2;
    }
    public void setOverTimeWage(int i3){
        this.overTimeWage = i3;
    }
    public void setTotal(){
        super.total = this.salary + this.overTimeWage;
    }
    
    public int getSalary(){
        return this.salary;
    }
    public int getOverTimeWage(){
        return this.overTimeWage;
    }
    
    public void calAndSetOverTimeWage(){
        this.overTimeWage = this.overTimePeriod * 200;
    }
    //insert code here
    
}

class WeeklyEmployee extends CommissionEmployee{
    private int weeklyRate;
    private int workingWeek;
    
    public void setWeeklyRate(int i1){
        this.weeklyRate = i1;
    }
    public void setWorkingWeek(int i2){
        this.workingWeek = i2;
    }
    public void calAndSetMonthlyWage(){
        super.monthlyWage = this.weeklyRate*this.workingWeek;
    }
    
    
}

class DailyEmployee extends CommissionEmployee{
    private int dailyRate;
    private int workingDay;
    
    public void setDailyRate(int i1){
        this.dailyRate = i1;
    }
    public void setWorkingDay(int i2){
        this.workingDay = i2;
    }
    
    public void calAndSetMonthlyWage(){
        super.monthlyWage = this.dailyRate * this.workingDay;
    }
    
}
