package com.aogaga.adurolife.domain.employee.dto;

import com.aogaga.adurolife.domain.employee.model.Employee;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class EmployeeDto {
    private Long Id;
    private String name;
    private String office;
    private String email;
    private String phone;
    private String role;


    public Employee convertToEmployee(){
       Employee employee = new Employee();
       employee.setId(getId());
       employee.setName(getName());
       employee.setOffice(getOffice());
       employee.setEmail(getEmail());
       employee.setPhone(getPhone());
       employee.setRole(getRole());
       return  employee;
    }
}
