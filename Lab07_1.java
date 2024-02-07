
import java.util.Scanner;
import java.text.DecimalFormat;

public class Lab07_1 {

    public static void printAllTeachers(Teacher [] teacher, int num_t){
        System.out.println("Teacher");
        int i;
        
        for(i=0;i<num_t;i++){
            System.out.print((i+1)+")");
            System.out.print(teacher[i].getName() + " ");
            System.out.print(teacher[i].getAge() + " ");
            System.out.print(teacher[i].getSalary() + " ");
            System.out.println();
        }
        
        //insert code here
    }
    
    public static void printAllStudents(Student [] stu, int num_s){
        System.out.println("Student");
        int i;
        
        for(i=0;i<num_s;i++){
            System.out.print((i+1)+")");
            System.out.print(stu[i].getName() + " ");
            System.out.print(stu[i].getAge() + " ");
            System.out.print(stu[i].getLevel());
            System.out.println();
        }
        
        //insert code here
    }
    
    public static double calAndPrintAvgAge(Student [] stu, int num_s, Teacher [] teacher, int num_t){
        DecimalFormat df = new DecimalFormat("0.00");
        int i, total_s = 0, total_t = 0;
        double avg_s, avg_t;
        
        for(i=0;i<num_s;i++){
            total_s += stu[i].getAge();
        }
        for(i=0;i<num_t;i++){
            total_t += teacher[i].getAge();
        }
        if (num_s == 0){
            avg_s = 0;
        }
        else{
            avg_s = (double)total_s/num_s;
        }
        if (num_t == 0){
            avg_t = 0;
        }
        else{
            avg_t = (double)total_t/num_t;
        }
        
        System.out.print(df.format(avg_s) + " ");
        System.out.print(df.format(avg_t));
        System.out.println();
        return avg_t;
        //insert code here
    }
    
    public static void countTeacher(Teacher [] teacher, int num_t, double avg_t){
        int i, count=0;
        for(i=0;i<num_t;i++){
            if (teacher[i].getAge() < avg_t){
                count += 1;
            }
        }
        System.out.println(count);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        Student [] stu = new Student[N];
        Teacher [] teacher = new Teacher[N];
        String perName;
        int i, is=0, it=0, age;
        
        char type;
        for (i=0;i<N;i++){
            input.nextLine(); // flush new line
            type = input.next().trim().charAt(0);
            type = Character.toLowerCase(type);
            input.nextLine(); // flush new line
            perName = input.nextLine().trim();
            age = input.nextInt();
            if (type == 't'){
                teacher[it] = new Teacher(perName, age, input.nextInt());
                it++;
            }
            else{
                stu[is] = new Student(perName, age, input.nextInt());
                is++;
            }
            
        }
        
        printAllStudents(stu, is);
        printAllTeachers(teacher, it);
        double avg = calAndPrintAvgAge(stu, is, teacher, it);
        countTeacher(teacher, it, avg);
        
        input.close();
    }
    
}
class Person{
    protected String name;
    protected int age;
    
    public Person(String s1, int i1){
        this.name = s1;
        this.age = i1;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    
}
class Student extends Person{
    private int level;
    
    public Student(String stu1, int i1, int i2){
        super(stu1, i1);
        this.level = i2;
    }
    
    public int getLevel(){
        return level;
    }
    
}
class Teacher extends Person{
    private int salary;
    
    public Teacher(String s1, int i1, int i2){
        super(s1,i1);
        this.salary = i2;
                
    }
    
    public int getSalary(){
        return salary;
    }
}