package com.project.L41.repository;

import com.project.L41.entity.Employee;
import com.project.L41.entity.EmployeeFunction;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static String URL = "jdbc:postgresql://localhost:5432/L41";
    private static String user = "postgres";
    private static String password = "admin";
    @Override
    public void createEmployee(Employee employee) throws SQLException {
        try(Connection conn = DriverManager.getConnection(URL,user,password)){
            PreparedStatement preparedStatement = conn.prepareStatement("" +
                    "INSERT INTO employees (first_name, last_name, employee_function, salary) VALUES (?, ?, ?,?);");
            preparedStatement.setString(1,employee.getFirstName());
            preparedStatement.setString(2,employee.getLastName());
            preparedStatement.setString(3, String.valueOf(employee.getEmployeeFunction()));
            preparedStatement.setDouble(4,employee.getSalary());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e){
            throw  new RuntimeException(e);
        }

    }

    @Override
    public List<Employee> loadAllEmployees() {
        List<Employee> employeeList;

        try(Connection conn = DriverManager.getConnection(URL,user,password)){
            PreparedStatement preparedStatement = conn.prepareStatement("" +
                    "SELECT * FROM employees;");
            ResultSet resultSet = preparedStatement.executeQuery();

            employeeList = new ArrayList<>();

            while (resultSet.next()){
                Long id = resultSet.getLong(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                EmployeeFunction  employeeFunction = EmployeeFunction.valueOf(resultSet.getString(4));
                double salary = resultSet.getDouble(5);

                Employee empl = new Employee(id,firstName, lastName, employeeFunction, salary);
                employeeList.add(empl);
            }

            preparedStatement.close();
        } catch (SQLException e){
            throw  new RuntimeException(e);
        }

        return employeeList;
    }

    @Override
    public Employee findEmployeeByID(long id) {
        Employee empl = null;
        try(Connection conn = DriverManager.getConnection(URL,user,password)){
            PreparedStatement preparedStatement = conn.prepareStatement("" +
                    "SELECT * FROM employees WHERE id = ?;");
           preparedStatement.setLong(1, id);



            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Long idDB = resultSet.getLong(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                EmployeeFunction  employeeFunction = EmployeeFunction.valueOf(resultSet.getString(4));
                double salary = resultSet.getDouble(5);

                empl = new Employee(idDB,firstName, lastName, employeeFunction, salary);

            }

            preparedStatement.close();
        } catch (SQLException e){
            throw  new RuntimeException(e);
        }
        return empl;
    }
}
