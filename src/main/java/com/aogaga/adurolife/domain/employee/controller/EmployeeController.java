package com.aogaga.adurolife.domain.employee.controller;


import com.aogaga.adurolife.domain.employee.dto.EmployeeDto;
import com.aogaga.adurolife.domain.employee.model.Employee;
import com.aogaga.adurolife.domain.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.all());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @PostMapping("/")
    public ResponseEntity<EmployeeDto>  createEmployee(@RequestBody EmployeeDto employee){
        return  ResponseEntity.ok(employeeService.create(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable(value = "id") Long id, @RequestBody EmployeeDto employee){
        return  ResponseEntity.ok(employeeService.update(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") Long id){
        employeeService.delete(id);
        return  ResponseEntity.ok("Delete");
    }


}
