package com.MotelDuParc.MotelManagementSystem.Controller;

import com.MotelDuParc.MotelManagementSystem.Model.Employee;
import com.MotelDuParc.MotelManagementSystem.Model.Guest;
import com.MotelDuParc.MotelManagementSystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> findAllEmployee(){
        try{
            List<Employee> findAllEmployee = employeeService.findAllEmployee();
            return new ResponseEntity<>(findAllEmployee, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Employee> findAnEmployee(@PathVariable("id") Long id){
        try{
            Employee findAnEmployee = employeeService.findAnEmployee(id);
            return new ResponseEntity<>(findAnEmployee,HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addAnEmployee(@RequestBody Employee employee){
        try {
            Employee newEmployee = employeeService.addAnEmployee(employee);
            return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        try {
            Employee updateEmployee = employeeService.updateAnEmployee(id,employee);
            return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long id){
        try {
            employeeService.deleteAnEmployee(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
