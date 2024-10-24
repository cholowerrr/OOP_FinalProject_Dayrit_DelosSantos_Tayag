/*
CYB-201 
6OOP - FINAL PROJECT
Dayrit, Gabriel Andrei G.
Delos Santos, Hailey D.
Tayag, Michael D.
*/

public class ContractualEmployee extends Employee {
    public ContractualEmployee(String name, int hoursWorked, double hourlyRate) {
        super(name, hoursWorked, hourlyRate);
    }

    @Override
    public double calculatePay() {
        return getHourlyRate() * getHoursWorked(); // Basic pay calculation for contractual employees
    }

    @Override
    public double calculateTax() {
        double totalPay = calculatePay();
        return totalPay * 0.15; // 15% tax for contractual employees
    }

    public double calculateTotalPayAfterTax() {
        return calculatePay() - calculateTax();
    }
}
