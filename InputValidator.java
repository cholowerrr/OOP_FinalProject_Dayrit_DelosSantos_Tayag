import java.util.Scanner;

public class InputValidator implements IInputValidator {
    private Scanner scanner;

    public InputValidator() {
        scanner = new Scanner(System.in);
    }

    @Override
    public int getValidIntInput(String prompt) {
        int input = -1;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                scanner.nextLine(); // Clear the newline
                if (input >= 0) {
                    return input;
                } else {
                    System.out.println("Please enter a non-negative integer.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    @Override
    public double getValidDoubleInput(String prompt) {
        double input = -1;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                input = scanner.nextDouble();
                scanner.nextLine(); // Clear the newline
                if (input >= 0) {
                    return input;
                } else {
                    System.out.println("Please enter a non-negative number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    @Override
    public String getValidStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    @Override
    public String getValidEmployeeType() {
        String type;
        while (true) {
            type = getValidStringInput("Enter Employee Type (FullTime/PartTime/Contractual): ");
            if (type.equalsIgnoreCase("fulltime") || type.equalsIgnoreCase("parttime") || type.equalsIgnoreCase("contractual")) {
                return type;
            } else {
                System.out.println("Invalid type. Please enter FullTime, PartTime, or Contractual.");
            }
        }
    }
}
