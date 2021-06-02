package com.aogaga.adurolife.domain.employee.repository;

import com.aogaga.adurolife.domain.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
