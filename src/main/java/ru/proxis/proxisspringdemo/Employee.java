package ru.proxis.proxisspringdemo;

import java.util.Objects;

public class Employee {
    private String fullName;
    private int department;
    private double salary;
    private int id;
    private static int counter = 1;

    public Employee(String fullName, int department, double salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.id = counter++;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, salary);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return department == employee.department &&
                Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(fullName, employee.fullName);
    }
}
