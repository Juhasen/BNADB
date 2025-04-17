package pl.juhas.bnabd.controller;

import org.springframework.web.bind.annotation.*;
import pl.juhas.bnabd.entity.Employee;
import pl.juhas.bnabd.service.EmployeeManager;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeApi {
    private EmployeeManager employeeManager;

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

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeManager.save(employee);
    }

    @PostMapping("/addMultiple")
    public List<Employee> addMultipleEmployee(@RequestBody List<Employee> employees) {
        return employeeManager.saveAll(employees);
    }

    @DeleteMapping("/delete/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long employeeId) {
        employeeManager.deleteById(employeeId);
    }

    @PutMapping("/edit/{employeeId}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("employeeId") Long employeeId) {
        employee.setId(employeeId);
        return employeeManager.save(employee);
    }

    @PutMapping("/{employeeId}/department/{departmentId}")
    public Employee setDepartment(@PathVariable("employeeId") Long employeeId, @PathVariable("departmentId") Long departmentId) {
        Employee employee =  employeeManager.setDepartmentForEmployee(employeeId, departmentId);
        return employeeManager.save(employee);
    }

    @GetMapping("/department/name/{name}")
    public List<Employee> getEmployeeByDepartment(@PathVariable("name") String name) {
        return employeeManager.findAllByDepartmentName(name);
    }

    @GetMapping("/department/id/{id}")
    public List<Employee> getEmployeeByDepartmentId(@PathVariable("id") Long id) {
        return employeeManager.findAllByDepartmentId(id);
    }

    @GetMapping("/lastname/{employeeLastName}")
    public List<Employee> getEmployeeBySurname(@PathVariable("employeeLastName") String lastName) {
        return employeeManager.findAllByLastname(lastName);
    }

}
