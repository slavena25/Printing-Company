package com.NETB406;

public class Employee {
    private EmployeeType employeeType;
    private final double BaseSalary = 1000.99;

    public Employee(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public double RealSalary(boolean income, double percentageManagerincrease) {
        if(income && employeeType.equals(EmployeeType.Managers)){
            return BaseSalary + (BaseSalary * (percentageManagerincrease * 0.01));
        }
        else{
            return BaseSalary;
        }


    }
}
