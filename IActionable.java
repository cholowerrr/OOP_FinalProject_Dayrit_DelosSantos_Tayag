/*
CYB-201 
6OOP - FINAL PROJECT
Dayrit, Gabriel Andrei G.
Delos Santos, Hailey D.
Tayag, Michael D.
*/

import java.util.List;

public interface IActionable {
    void addEmployee(Employee employee);
    void displayEmployees();
    void updateEmployee(int index, String name, int hoursWorked, double hourlyRate);
    void removeEmployee(int index);
    Employee searchEmployeeByName(String name);
    List<Employee> filterEmployeesByType(String type);
}