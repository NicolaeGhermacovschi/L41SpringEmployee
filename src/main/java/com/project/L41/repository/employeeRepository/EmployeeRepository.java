package com.project.L41.repository.employeeRepository;

import com.project.L41.model.employeeModel.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeRepository {
    void createEmployee(Employee employee) throws SQLException;
    List<Employee> loadAllEmployees() throws SQLException;

    Employee findEmployeeByID(long id) throws SQLException;

}
