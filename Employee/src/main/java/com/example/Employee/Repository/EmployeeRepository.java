package com.example.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Employee.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
