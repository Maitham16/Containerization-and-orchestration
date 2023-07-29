package com.example.Employee.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Employee.Model.Employee;
import com.example.Employee.Repository.EmployeeRepository;

import jakarta.transaction.TransactionScoped;
import lombok.RequiredArgsConstructor;

@Service
@TransactionScoped
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    // find all method
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    // find method
    public Employee find(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee with id " + id + " does not exist"));
    }

    // create method
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    // update method
    public Employee update(Long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee with id " + id + " does not exist"));

        existingEmployee.setName(employee.getName());
        existingEmployee.setRole(employee.getRole());

        return employeeRepository.save(existingEmployee);
    }

    // delete method
    public void delete(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new IllegalArgumentException("Employee with id " + id + " does not exist");
        }
        employeeRepository.deleteById(id);
    }
}
