package com.sprigboot_crud.demo.services.impl;

import com.sprigboot_crud.demo.exceptions.ResponseNotFound;
import com.sprigboot_crud.demo.models.Employee;
import com.sprigboot_crud.demo.repositories.EmployeeRepository;
import com.sprigboot_crud.demo.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getSingleEmployee(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee employeeExists = getSingleEmployee(id).orElseThrow(()->new ResponseNotFound("Employee", "Employee", id));
        employeeExists.setEmail(employee.getEmail());
        employeeExists.setFirstname(employee.getFirstname());
        employeeExists.setLastname(employee.getLastname());

        return employeeRepository.save(employeeExists);
    }

    @Override
    public String deleteEmployee(Long id) {
        Employee employeeExist = getSingleEmployee(id).orElseThrow(()-> new ResponseNotFound("Employee", "Employee", id));
       employeeRepository.delete(employeeExist);
       return "Sucess";
    }
}
