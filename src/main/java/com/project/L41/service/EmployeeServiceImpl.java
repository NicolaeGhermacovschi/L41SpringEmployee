package com.project.L41.service;

import com.project.L41.entity.Employee;
import com.project.L41.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public void addEmployee( Employee employee) {
        System.out.println("create an Employee");
         try{
             employeeRepository.createEmployee(employee);
         } catch (SQLException e){
             e.printStackTrace();
         }
    }

    @Override
    public List<Employee> getAllEmployees() {
        System.out.println("get all employee");
        List<Employee> employeeList = new ArrayList<>();
        try {
            employeeList = employeeRepository.loadAllEmployees();
        } catch (SQLException e ){
            e.printStackTrace();
        }

        return employeeList;
    }

    @Override
    public Employee getEmployeeByID(Long id) {
        System.out.println("get employee by id");
        Employee employee = null;
        try {
            employee = employeeRepository.findEmployeeByID(id);
        } catch ( SQLException e ){
            e.printStackTrace();
        }
        return null;
    }
}
