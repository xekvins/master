package ru.proxis.proxisspringdemo;

public class EmployeeStorageIsFullException extends RuntimeException {
        public EmployeeStorageIsFullException() {
            super("Employee storage is full");
        }
    }
