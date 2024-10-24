public abstract class Employee {
    protected String name;
    protected int hoursWorked;
    protected double hourlyRate;

    public Employee(String name, int hoursWorked, double hourlyRate) {
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public String getName() {
        return name;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double calculatePay() {
        return hoursWorked * hourlyRate; // Calculate base pay
    }
    public abstract double calculateTax();
}