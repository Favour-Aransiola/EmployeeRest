package com.sprigboot_crud.demo.controllers;

import com.sprigboot_crud.demo.models.Employee;
import com.sprigboot_crud.demo.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping()
    public ResponseEntity<Employee> createEployee(@RequestBody Employee employee){

        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<Employee> allEmployees(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getOneEmployee(@PathVariable("id") String id){
        Long identity = Long.parseLong(id);
        return employeeService.getSingleEmployee(identity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee ){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(id,employee), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        return employeeService.deleteEmployee(id);
    }


}
