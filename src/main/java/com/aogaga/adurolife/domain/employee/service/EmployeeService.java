package com.aogaga.adurolife.domain.employee.service;

import com.aogaga.adurolife.domain.employee.dto.EmployeeDto;
import com.aogaga.adurolife.domain.employee.model.Employee;
import com.aogaga.adurolife.domain.employee.repository.EmployeeRepository;
import com.aogaga.adurolife.utility.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements CrudService<EmployeeDto> {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto create(EmployeeDto entity) {

        Employee employee = employeeRepository.save(entity.convertToEmployee());

        return employee.convertToDto();
    }

    @Override
    public EmployeeDto getById(Long Id) {
        Employee employee = employeeRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Employee Not found"));
        return employee.convertToDto();
    }

    @Override
    public List<EmployeeDto> all() {

        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDto> dtoList = new ArrayList<>();

        if(employeeList.size() > 0){

            for(Employee employee : employeeList){
                dtoList.add(employee.convertToDto());
            }

            return dtoList;
        }
        return null;
    }

    @Override
    public EmployeeDto update(EmployeeDto entity) {
        Employee updatedEmployee =  employeeRepository.save(entity.convertToEmployee());
        return updatedEmployee.convertToDto();
    }

    @Override
    public void delete(Long Id) {
        EmployeeDto employee = this.getById(Id);
        employeeRepository.delete(employee.convertToEmployee());
    }



}