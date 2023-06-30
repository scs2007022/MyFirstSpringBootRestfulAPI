package com.my.first.restful.api.helloworld.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.my.first.restful.api.helloworld.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    HashMap<String,Employee> storage = new HashMap<>();
    public EmployeeServiceImpl(){
        storage.put("001",new Employee("001", 10000));
        storage.put("002",new Employee("002", 20000));
    }
    
    @Override
    public List<Employee> getAllEmployee(){
        return new ArrayList<>(storage.values());
    }

    @Override
    public Employee getEmployeeById(String staffId){
        return storage.get(staffId);
    }

    @Override
    public Employee createEmployee(Employee employee){
        storage.put(employee.getStaffId(),employee);
        return employee;
    }

    @Override
    public Employee updateEmployeeById(String originalStaffId, Employee employee){
        storage.remove(originalStaffId);
        storage.put(employee.getStaffId(),employee);
        return employee;
    }

    @Override
    public Employee deleteEmployeeById(String staffId){
        return storage.remove(staffId);
    }
}
