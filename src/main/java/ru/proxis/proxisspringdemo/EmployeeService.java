package ru.proxis.proxisspringdemo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeService {
    private final Map<Integer, Employee> employeeMap = new HashMap<>();
    private static final int MAX_EMPLOYEES = 100;

    public Employee addEmployee(String fullName, int department, double salary) {
        if (employeeMap.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(fullName, department, salary);
        if (employeeMap.containsValue(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeMap.put(employee.getId(), employee);
        return employee;
    }

    public Employee removeEmployee(int id) {
        Employee employee = employeeMap.remove(id);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public Employee findEmployee(int id) {
        Employee employee = employeeMap.get(id);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public Employee getEmployeeWithMaxSalary(int departmentId) {
        return employeeMap.values().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee getEmployeeWithMinSalary(int departmentId) {
        return employeeMap.values().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public List<Employee> getEmployeesByDepartment(int departmentId) {
        return employeeMap.values().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> getAllEmployeesByDepartments() {
        return employeeMap.values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
