/*
CYB-201 
6OOP - FINAL PROJECT
Dayrit, Gabriel Andrei G.
Delos Santos, Hailey D.
Tayag, Michael D.
*/

public interface IInputValidator {
    int getValidIntInput(String prompt);
    double getValidDoubleInput(String prompt);
    String getValidStringInput(String prompt);
    String getValidEmployeeType();
}