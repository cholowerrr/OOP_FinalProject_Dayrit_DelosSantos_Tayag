public class FullTimeEmployee extends Employee {
    private static final double BENEFITS = 1000.0; // Fixed benefits value

    public FullTimeEmployee(String name, int hoursWorked, double hourlyRate) {
        super(name, hoursWorked, hourlyRate);
    }

    @Override
    public double calculatePay() {
        double basePay = super.calculatePay();
        return basePay + BENEFITS; // Include fixed benefits in total pay
    }

    @Override
    public double calculateTax() {
        double totalPay = calculatePay();
        return totalPay * 0.2; // 20% tax for full-time employees
    }

    public double calculateTotalPayAfterTax() {
        return calculatePay() - calculateTax();
    }
}
