package com.my.first.restful.api.helloworld.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.first.restful.api.helloworld.model.Employee;
import com.my.first.restful.api.helloworld.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return new ResponseEntity<List<Employee>>(employeeServiceImpl.getAllEmployee(), HttpStatus.OK);
    }

    @GetMapping("/{staffId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String staffId){
        return new ResponseEntity<Employee>(employeeServiceImpl.getEmployeeById(staffId), HttpStatus.OK); 
    }

    @PostMapping("")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeServiceImpl.createEmployee(employee),HttpStatus.CREATED);
    }

    @PutMapping("/{originalStaffId}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable String originalStaffId, @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeServiceImpl.updateEmployeeById(originalStaffId, employee),HttpStatus.OK);
    }

    @DeleteMapping("/{staffId}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable String staffId){
        return new ResponseEntity<Employee>(employeeServiceImpl.deleteEmployeeById(staffId),HttpStatus.OK);
    }
}
