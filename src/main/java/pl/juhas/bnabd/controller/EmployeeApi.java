package pl.juhas.bnabd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.juhas.bnabd.entity.Employee;
import pl.juhas.bnabd.service.EmployeeManager;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeApi {
    private EmployeeManager employeeManager;

    @Autowired
    public EmployeeApi(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeManager.findAll();
    }

    @GetMapping("/id")
    public Optional<Employee> getById(@RequestParam Long id) {
        return employeeManager.findById(id);
    }

    @GetMapping(value = "/{employeeId}")
    public Optional<Employee> getByEmployeeId(@PathVariable("employeeId") Long employeeId) {
        return employeeManager.findById(employeeId);
    }
}
