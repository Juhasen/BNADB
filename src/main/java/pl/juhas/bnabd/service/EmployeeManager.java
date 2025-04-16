package pl.juhas.bnabd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.juhas.bnabd.entity.Department;
import pl.juhas.bnabd.entity.Employee;
import pl.juhas.bnabd.repository.DepartmentRepository;
import pl.juhas.bnabd.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeManager {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public EmployeeManager(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        super();
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> saveAll(Iterable<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee setDepartmentForEmployee(Long employeeId, Long departmentId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (employee.isPresent() && department.isPresent()) {
            employee.get().setDepartment(department.get());
        }
        return employee.get();
    }
}
