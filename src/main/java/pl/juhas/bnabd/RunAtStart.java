package pl.juhas.bnabd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pl.juhas.bnabd.model.Department;
import pl.juhas.bnabd.model.Employee;
import pl.juhas.bnabd.repository.DepartmentRepository;
import pl.juhas.bnabd.repository.EmployeeRepository;

import java.math.BigDecimal;
import java.util.List;

@Component
public class RunAtStart {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;


    @Autowired
    public RunAtStart(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        super();
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }


    private void showEmployees(){
        Iterable<Employee> employees =  employeeRepository.findAll();
        for(Employee employee : employees){
            System.out.println(employee);
        }
    }

    private void showDepartments(){
        Iterable<Department> departments = departmentRepository.findAll();
        for(Department department : departments){
            System.out.println(department);
        }
    }


    @Bean
    public CommandLineRunner runner(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        return args -> {
            employeeRepository.save(new Employee("Jan", "Kowalsky", BigDecimal.valueOf(1000)));
            employeeRepository.save(new Employee("Krzysztof", "Nowalsky", BigDecimal.valueOf(3000)));
            departmentRepository.save(new Department("Java Development", "Programers", "Lakowa"));
            departmentRepository.save(new Department("C++ Development", "Programers", "Sadowa"));
            showEmployees();
            showDepartments();

            List<Employee> employees = employeeRepository.findEmployeeByLastNameStartingWith("K");
            System.out.println("Znaleziony: " + employees);

            Department department = departmentRepository.getFirstById(1L);
            if (department == null) {
                System.out.println("Nie znaleziono działu o podanym ID.");
                return;
            }

            Employee newEmployee = new Employee("Anna", "Kowalska", BigDecimal.valueOf(2000));
            employeeRepository.save(newEmployee);
            department.getEmployees().add(newEmployee);
            departmentRepository.save(department);
            System.out.println("Zaktualizowany department: " + department);

        };
    }
}
