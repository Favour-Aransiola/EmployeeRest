package com.sprigboot_crud.demo.services;

import com.sprigboot_crud.demo.models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Optional<Employee> getSingleEmployee(Long id);

    Employee updateEmployee(Long id, Employee employee);

    String deleteEmployee(Long id);
}
