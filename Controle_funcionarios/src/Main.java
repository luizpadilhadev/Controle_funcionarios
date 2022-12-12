import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<Employee>();

        System.out.println("Enter the number of employees: ");
        int n = sc.nextInt();

        for (int i = 1; i<=n; i++){
            System.out.println("Employee #" + i +" data: ");
            System.out.print("Outsourced (y/n)? ");
            char res = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.next();
            sc.nextLine();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            if (res == 'y'){
                System.out.print("Additional charges: ");
                double addC = sc.nextDouble();
                Employee employee = new OutsourcedEmployee(name, hours, valuePerHour, addC);
                employees.add(employee);

            }
            else {
                Employee employee = new Employee(name, hours, valuePerHour);
                employees.add(employee);
            }
            
        }
        System.out.println();
        System.out.println("PAYMENTS: ");
        for (Employee employee : employees){
            System.out.println(employee.getName() + " - $ " + String.format("%.2f", employee.payment()));

        }


        sc.close();

    }
}