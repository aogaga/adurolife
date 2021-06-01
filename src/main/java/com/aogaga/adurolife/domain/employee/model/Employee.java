package com.aogaga.adurolife.domain.employee.model;

import com.aogaga.adurolife.domain.employee.dto.EmployeeDto;
import com.aogaga.adurolife.utility.AbstractEntityObject;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class Employee  extends AbstractEntityObject {

    @Column(name="name", length=100, nullable=false, unique=false)
    private String name;

    @Column(name="office", length=4, nullable=false, unique=false)
    private  String office;

    @Column(name="email", length=150, nullable=false, unique=true)
    private String email;

    @Column(name="phone", length=12, nullable=false, unique=true)
    private String phone;

    @Column(name="role", length=150, nullable=false, unique=false)
    private String role;

    public EmployeeDto convertToDto(){
        EmployeeDto dto = new EmployeeDto();
        dto.setId(getId());
        dto.setName(getName());
        dto.setOffice(getOffice());
        dto.setEmail(getEmail());
        dto.setPhone(getPhone());
        dto.setRole(getRole());
        return dto;
    }
}
