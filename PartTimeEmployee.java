public class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, int hoursWorked, double hourlyRate) {
        super(name, hoursWorked, hourlyRate);
    }

    @Override
    public double calculatePay() {
        return getHoursWorked() * getHourlyRate(); // Only hourly rate for part-time
    }

    @Override
    public double calculateTax() {
        double totalPay = calculatePay();
        return totalPay * 0.1; // 10% tax for part-time employees
    }

    public double calculateTotalPayAfterTax() {
        return calculatePay() - calculateTax();
    }
}
