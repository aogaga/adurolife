package com.aogaga.adurolife.domain.employee.repository;

import com.aogaga.adurolife.domain.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    default Employee create(Employee employee){
        return this.save(employee);
    }

    default Employee update(Employee employee){
        Assert.notNull(employee.getId());
        return this.save(employee);
    }

    default Employee upsert(Employee employee){
        if(employee.getId() == null){
            return create(employee);
        }
        return  update(employee);
    }
}
