package com.Task.Service;

import com.Task.Entity.Employee;
import com.Task.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee findByLoginId(String loginId) {
        return employeeRepository.findByLoginId(loginId);
    }
}
