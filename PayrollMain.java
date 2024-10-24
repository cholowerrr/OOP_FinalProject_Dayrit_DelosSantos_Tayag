import java.util.Scanner;

public class PayrollMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PayrollSystem payrollSystem = new PayrollSystem();
        IInputValidator inputValidator = new InputValidator();
        PayrollActions payrollActions = new PayrollActions(payrollSystem, inputValidator);

        while (true) {
            System.out.println("\n*********** Heyts Hey You Payroll System ***********");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Remove Employee");
            System.out.println("5. Search Employee by Name");
            System.out.println("6. Filter Employees by Type");
            System.out.println("7. Exit");
            System.out.println("\n****************************************************");
            System.out.print("Choose an option: ");

            int choice = inputValidator.getValidIntInput("");
            switch (choice) {
                case 1: // Add Employee
                    payrollActions.addEmployee();
                    break;

                case 2: // Display Employees
                    payrollActions.displayEmployees();
                    break;

                case 3: // Update Employee
                    payrollActions.updateEmployee();
                    break;

                case 4: // Remove Employee
                    payrollActions.removeEmployee();
                    break;

                case 5: // Search Employee by Name
                    payrollActions.searchEmployee();
                    break;

                case 6: // Filter Employees by Type
                    payrollActions.filterEmployees();
                    break;

                case 7: // Exit
                    System.out.println("Exiting Heyts Hey You Payroll System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
