import java.util.ArrayList;

abstract class Employee
{
    private String name;
    private int id;
    
    public Employee(String name,int id){
        this.name=name;
        this.id=id;
    }

    public String getName(){
        return name;
    }
    public int getid(){
        return id;
    }
    public abstract double calculateSalary();
    
    @Override
    public String toString(){
        return "Employee[name="+name+",id="+id+",salary="+calculateSalary()+"]";
    }
}



class fullTimeEmplyee extends Employee {
    private double monthlySalary;
    public fullTimeEmplyee(String name,int id,double salary){
        super(name,id);
        monthlySalary=salary;
    }
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}

class partTimeEmployee extends Employee {
    private int hours;
    private double hour_rate;

    public partTimeEmployee(int hours,double hour_rate,String name,int id){
        super(name, id);
        this.hours=hours;
        this.hour_rate=hour_rate;
    }

    @Override
    public double calculateSalary(){
        return hour_rate*hours;
    }
}


class PayrollSystem {
    private ArrayList<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void remove(int id){
        Employee em = null;
        for(Employee i:employeeList){
            if(i.getid()==id){
                em = i;
                break;
            }   
        }
        if(em!=null) {
            employeeList.remove(em);
        }
    }
    public void display (){
        for(Employee i:employeeList){
            System.out.println(i);
        }
    }
}









public class App {
    public static void main(String[] args) throws Exception {
        PayrollSystem paroll = new PayrollSystem();
        fullTimeEmplyee emp1 = new fullTimeEmplyee("vikas", 121, 70000.25);
        partTimeEmployee e = new partTimeEmployee(25, 25.250, "vikas", 12345);
        paroll.addEmployee(emp1);
        paroll.addEmployee(e);
        System.out.println("Initial Employee Details: ");
        paroll.display();
        paroll.remove(121);
        paroll.display();
    }
}
