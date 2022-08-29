package com.zhadraoui.swagger.controller;


import com.zhadraoui.swagger.model.Employee;
import com.zhadraoui.swagger.repository.EmployeeRepository;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(value = " Hidden Value",description = "Valleur Afficher comme discription")
@Tag(name = "Nom Afficher")
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

    //http://localhost:8080/api/show
    @GetMapping("/show")
    public ResponseEntity<Employee> show(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                employeeRepository.findById(id).get()
        );
    }


    //http://localhost:8080/api/delete
    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id) {
        employeeRepository.deleteById(id);
    }


    //http://localhost:8080/api/edit
    @PutMapping("/edit")
    public void edit(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }

}
