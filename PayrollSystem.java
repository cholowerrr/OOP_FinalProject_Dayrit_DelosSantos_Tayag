import java.util.ArrayList;
import java.util.List;

public class PayrollSystem implements IActionable {
    private List<Employee> employees;

    public PayrollSystem() {
        employees = new ArrayList<>();
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added: " + employee.getName());
    }

    @Override
    public void displayEmployees() {
        System.out.println("\n****************************************************");
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }
    
        for (Employee employee : employees) {
            double originalPay = employee.calculatePay();  // Get the original pay
            double taxDeduction = employee.calculateTax();  // Get the tax deduction
            double totalPayAfterTax = originalPay - taxDeduction;  // Calculate total pay after tax
    
            System.out.println("Employee: " + employee.getName() 
                    + " | Original Pay: PHP " + originalPay 
                    + " | Tax Deduction: PHP " + taxDeduction
                    + " | Total Pay After Tax: PHP " + totalPayAfterTax);
        }
        System.out.println("****************************************************");
    }    

    @Override
    public void updateEmployee(int index, String name, int hoursWorked, double hourlyRate) {
        if (index >= 0 && index < employees.size()) {
            Employee emp = employees.get(index);
            emp.name = name; // Update name
            emp.hoursWorked = hoursWorked; // Update hours worked
            emp.hourlyRate = hourlyRate; // Update hourly rate
            System.out.println("Employee updated: " + emp.getName());
        } else {
            System.out.println("Error: Employee index out of bounds.");
        }
    }

    @Override
    public void removeEmployee(int index) {
        if (index >= 0 && index < employees.size()) {
            Employee removedEmployee = employees.remove(index);
            System.out.println("Employee removed: " + removedEmployee.getName());
        } else {
            System.out.println("Error: Employee index out of bounds.");
        }
    }

    @Override
    public Employee searchEmployeeByName(String name) {
        for (Employee emp : employees) {
            if (emp.getName().equalsIgnoreCase(name)) {
                System.out.println("Employee found: " + emp.getName());
                return emp;
            }
        }
        System.out.println("Employee with name '" + name + "' not found.");
        return null; // Return null if not found
    }

    @Override
    public List<Employee> filterEmployeesByType(String type) {
        List<Employee> filteredEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (type.equalsIgnoreCase("fulltime") && employee instanceof FullTimeEmployee) {
                filteredEmployees.add(employee);
            } else if (type.equalsIgnoreCase("parttime") && employee instanceof PartTimeEmployee) {
                filteredEmployees.add(employee);
            } else if (type.equalsIgnoreCase("contractual") && employee instanceof ContractualEmployee) {
                filteredEmployees.add(employee);
            }
        }
        if (filteredEmployees.isEmpty()) {
            System.out.println("No employees found for the type: " + type);
        } else {
            for (Employee emp : filteredEmployees) {
                System.out.println("Filtered employee: " + emp.getName() + " of type: " + type);
            }
        }
        return filteredEmployees; // Return filtered list
    }

    public List<Employee> getEmployees() {
        return employees; // Allow access to the employees list
    }
}