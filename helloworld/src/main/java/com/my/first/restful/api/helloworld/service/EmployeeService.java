package com.my.first.restful.api.helloworld.service;


import java.util.List;

import com.my.first.restful.api.helloworld.model.Employee;

public interface EmployeeService {
    
    List<Employee> getAllEmployee();
    Employee getEmployeeById(String staffId);
    Employee createEmployee(Employee employee);
    Employee updateEmployeeById(String origianlStaffId,Employee employee);
    Employee deleteEmployeeById(String staffId);
}
