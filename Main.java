import java.util.*;
abstract class Employee{
   private String name;
   private int id;
   public Employee(String name,int id){
   this.name=name;
   this.id=id;
   }
   public String getName()
   {
    return name;
   }
   public int getId()
   {
    return id;
   }
   public abstract double calculateSalary();
   @Override
   public String toString(){
    return "Employee[name="+name+"id="+id+",salary="+calculateSalary()+"]";
   }
}
class FullTimeEmployee extends Employee{
    private double monthlysalary;
public FullTimeEmployee(String name,int id,double monthlySalary){
    super(name,id);
    this.monthlysalary=monthlySalary;}
    @Override
    public double calculateSalary(){
        return monthlysalary;
    }
}
class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;
    public PartTimeEmployee(String name,int id,int hoursWorked,double hourlyRate){
     super(name,id);
     this.hoursWorked=hoursWorked;
     this.hourlyRate=hourlyRate;

    }
    @Override
    public double calculateSalary(){
        return hoursWorked*hourlyRate;
    }
}
class PayrollSystem{
    private ArrayList<Employee> empList;
    public PayrollSystem(){
          empList = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        empList.add(employee);
    }
    public void removeEmployee(int id){
        Employee employeeToRemove =null;
        for(Employee employee: empList){
            if(employee.getId()==id){
                employeeToRemove=employee;
                break;
            }
             
        }
        if(employeeToRemove!= null){
            empList.remove(employeeToRemove);
        }
        else{
            System.out.println("The"+id+"does not exist");
        }
    }
    public void displayEmployee()
  {
    for(Employee employee:empList){
        System.out.println(employee);
    }
  }    
}
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        PayrollSystem payrollSystem = new PayrollSystem();

        System.out.print("Enter number of employees to add: ");
        int numEmployees = scanner.nextInt();

        for (int i = 0; i < numEmployees; i++) {
            System.out.println("\nEnter details for employee " + (i + 1));
            System.out.print("Enter name: ");
            String name = scanner.next();
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            System.out.print("Is this employee Full-Time or Part-Time? (F/P): ");
            char type = scanner.next().toUpperCase().charAt(0);

            if (type == 'F') {
                System.out.print("Enter monthly salary: ");
                double monthlySalary = scanner.nextDouble();
                FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(name, id, monthlySalary);
                payrollSystem.addEmployee(fullTimeEmployee);
            } else if (type == 'P') {
                System.out.print("Enter hours worked: ");
                int hoursWorked = scanner.nextInt();
                System.out.print("Enter hourly rate: ");
                double hourlyRate = scanner.nextDouble();
                PartTimeEmployee partTimeEmployee = new PartTimeEmployee(name, id, hoursWorked, hourlyRate);
                payrollSystem.addEmployee(partTimeEmployee);
            } else {
                System.out.println("Invalid employee type.");
            }
        }

        System.out.println("\nAll Employee Details:");
        payrollSystem.displayEmployee();

        System.out.print("\nEnter the ID of the employee to remove: ");
        int removeId = scanner.nextInt();
        payrollSystem.removeEmployee(removeId);

        System.out.println("\nRemaining Employee Details:");
        payrollSystem.displayEmployee();

        scanner.close();
    }
}




    

    
    
