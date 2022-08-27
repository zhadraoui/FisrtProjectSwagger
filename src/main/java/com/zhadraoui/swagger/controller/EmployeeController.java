package com.zhadraoui.swagger.controller;


import com.zhadraoui.swagger.model.Employee;
import com.zhadraoui.swagger.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
// http://localhost:8080/api
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // http://localhost:8080/api/save
    @PostMapping("/save")
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                employeeRepository.save(employee)
        );
    }

    @GetMapping("/show")
    public ResponseEntity<Employee> show(@RequestParam int id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                employeeRepository.findById((long) id).get()
        );
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam int id) {
        employeeRepository.deleteById((long) id);
    }

    @PutMapping("/edit")
    public void edit(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }

}
