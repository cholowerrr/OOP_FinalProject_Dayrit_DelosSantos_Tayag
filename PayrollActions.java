/*
CYB-201 
6OOP - FINAL PROJECT
Dayrit, Gabriel Andrei G.
Delos Santos, Hailey D.
Tayag, Michael D.
*/

import java.util.List;

public class PayrollActions {
    private PayrollSystem payrollSystem;
    private IInputValidator inputValidator;

    public PayrollActions(PayrollSystem payrollSystem, IInputValidator inputValidator) {
        this.payrollSystem = payrollSystem;
        this.inputValidator = inputValidator;
    }

    public void addEmployee() {
        System.out.println("\n****************************************************");
        String employeeType = inputValidator.getValidEmployeeType();
        String name = inputValidator.getValidStringInput("Enter Employee Name: ");
        int hoursWorked = inputValidator.getValidIntInput("Enter Hours Worked: ");
        double hourlyRate = inputValidator.getValidDoubleInput("Enter Hourly Rate: ");
    
        if (employeeType.equalsIgnoreCase("FullTime")) {
            FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(name, hoursWorked, hourlyRate);
            payrollSystem.addEmployee(fullTimeEmployee);
        } else if (employeeType.equalsIgnoreCase("PartTime")) {
            PartTimeEmployee partTimeEmployee = new PartTimeEmployee(name, hoursWorked, hourlyRate);
            payrollSystem.addEmployee(partTimeEmployee);
        } else {
            System.out.println("Invalid employee type.");
        }
        System.out.println("****************************************************");
    }    

    public void displayEmployees() {
        payrollSystem.displayEmployees();
    }

    public void updateEmployee() {
        System.out.println("\n****************************************************");
        int updateIndex = inputValidator.getValidIntInput("Enter Employee Index to Update (starting from 1): ");
        int internalUpdateIndex = updateIndex - 1; // Adjust for list index

        if (internalUpdateIndex >= 0 && internalUpdateIndex < payrollSystem.getEmployees().size()) {
            String name = inputValidator.getValidStringInput("Enter New Employee Name: ");
            int hoursWorked = inputValidator.getValidIntInput("Enter New Hours Worked: ");
            double hourlyRate = inputValidator.getValidDoubleInput("Enter New Hourly Rate: ");
            payrollSystem.updateEmployee(internalUpdateIndex, name, hoursWorked, hourlyRate);
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Error: Employee index out of bounds.");
        }
        System.out.println("****************************************************");
    }

    public void removeEmployee() {
        System.out.println("\n****************************************************");
        int removeIndex = inputValidator.getValidIntInput("Enter Employee Index to Remove (starting from 1): ");
        payrollSystem.removeEmployee(removeIndex - 1); // Adjust for list index
        System.out.println("****************************************************");
    }

    public void searchEmployee() {
        System.out.println("\n****************************************************");
        String searchName = inputValidator.getValidStringInput("Enter Employee Name to Search: ");
        Employee foundEmployee = payrollSystem.searchEmployeeByName(searchName);
        if (foundEmployee != null) {
            System.out.println(foundEmployee.getName() + ": " + foundEmployee.calculatePay());
        } else {
            System.out.println("Employee not found.");
        }
        System.out.println("****************************************************");
    }

    public void filterEmployees() {
        String filterType = inputValidator.getValidEmployeeType();
        List<Employee> filteredEmployees = payrollSystem.filterEmployeesByType(filterType);
        System.out.println("\n****************************************************");
        if (filteredEmployees.isEmpty()) {
            System.out.println("No employees found for the specified type.");
        } else {
            System.out.println("Filtered Employees:");
            for (Employee emp : filteredEmployees) {
                System.out.println(emp.getName() + ": " + emp.calculatePay());
            }
        }
        System.out.println("****************************************************");
    }
}
