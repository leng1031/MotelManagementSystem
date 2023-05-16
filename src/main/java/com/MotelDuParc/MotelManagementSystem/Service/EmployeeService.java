package com.MotelDuParc.MotelManagementSystem.Service;

import com.MotelDuParc.MotelManagementSystem.Model.Employee;
import com.MotelDuParc.MotelManagementSystem.Repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee addAnEmployee(Employee requestBody){
        Employee addAneEmployee = saveEmployee(requestBody);
        return addAneEmployee;
    }

    public Boolean deleteAnEmployee(Long employeeId){
        employeeRepository.deleteById(employeeId);
        return true;
    }

    public Employee updateAnEmployee(Long employeeId, Employee requestBody){
        Employee findAnEmployee = findAnEmployee(employeeId);
        if (findAnEmployee == null) return null;

        if (requestBody.getFirstName() != null && requestBody.getFirstName() != ""){
            findAnEmployee.setFirstName(requestBody.getFirstName());
        }
        if (requestBody.getLastName() != null && requestBody.getLastName() != ""){
            findAnEmployee.setLastName(requestBody.getLastName());
        }
        if (requestBody.getPhoneNumber() != null && requestBody.getPhoneNumber() != ""){
            findAnEmployee.setPhoneNumber(requestBody.getPhoneNumber());
        }
        if (requestBody.getAddress() != null && requestBody.getAddress() != ""){
            findAnEmployee.setAddress(requestBody.getAddress());
        }

        Employee updateAnEmployee = saveEmployee(findAnEmployee);
        return updateAnEmployee;


    }

    public List<Employee> findAllEmployee(){
        List<Employee> findAllEmployee = employeeRepository.findAll();
        return findAllEmployee;
    }

    public Employee findAnEmployee(Long employeeId){
        Employee findAnEmployee = employeeRepository.findById(employeeId).orElse(null);
        return findAnEmployee;
    }

}
