package ru.proxis.proxisspringdemo;

    public class EmployeeNotFoundException extends RuntimeException {
        public EmployeeNotFoundException() {
            super("Employee not found");
        }
    }


