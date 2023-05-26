package com.project.L41.service;

import com.project.L41.entity.Employee;

import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeByID(Long id);

}
