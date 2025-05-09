package pl.juhas.bnabd.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.juhas.bnabd.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee as e WHERE e.lastName LIKE CONCAT(:letter,'%') ")
    List<Employee> findEmployeeByLastNameStartingWith(@Param("letter") String letter);

    List<Employee> findEmployeesByDepartment_Name(String departmentName);

    List<Employee> findAllByDepartment_Id(Long departmentId);

    List<Employee> findEmployeesByLastName(String lastName);

    //Methods for exercise 2
    Page<Employee> findAll(Pageable pageable);

    List<Employee> findAll(Sort sort);

    List<Employee> findEmployeesByFirstNameIgnoreCase(String firstName);

    List<Employee> findEmployeesBySalaryBetween(Double salaryLow, Double salaryHigh);

}
