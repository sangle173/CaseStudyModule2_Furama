package Controllers;

import Commons.FuncWritingReading;
import Models.Employee;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class EmployeesCVManager {
    Scanner scanner = new Scanner(System.in);
    FuncWritingReading funcWritingReading = new FuncWritingReading();
    EmployeeManagement employeeManagement = new EmployeeManagement();

    public Stack<Employee> employeesCVCabinets() {
        Stack<Employee> employeeStack = new Stack<>();
        List<String[]> list = funcWritingReading.readFromFile("Employees.csv");
        for (String[] employeeInfo : list) {
            Employee employee = new Employee(employeeInfo[0], Byte.parseByte(employeeInfo[1]), employeeInfo[2]);
            employeeStack.push(employee);
        }
        return employeeStack;
    }

    public void searchEmployee() {
        Stack<Employee> employeeStack = employeesCVCabinets();
        System.out.print("Enter your name: ");
        String nameSearch = scanner.nextLine();
        while (true) {
            if (!employeeStack.isEmpty()) {
                Employee e = employeeStack.pop();
                if (e.getEmployeeName().equals(nameSearch)) {
                    System.out.println(e);
                    break;
                }

            } else {
                System.out.println("The name is not available");
                break;
            }
        }
    }
}
