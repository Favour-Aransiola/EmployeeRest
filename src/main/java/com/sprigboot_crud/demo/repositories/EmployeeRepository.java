package com.sprigboot_crud.demo.repositories;


import com.sprigboot_crud.demo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
