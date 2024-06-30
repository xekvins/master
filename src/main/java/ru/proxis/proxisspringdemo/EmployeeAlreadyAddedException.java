package ru.proxis.proxisspringdemo;

public class EmployeeAlreadyAddedException extends RuntimeException {
        public EmployeeAlreadyAddedException() {
            super("Employee already added");
        }
}
