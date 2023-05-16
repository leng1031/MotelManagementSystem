package com.MotelDuParc.MotelManagementSystem.Repo;

import com.MotelDuParc.MotelManagementSystem.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
