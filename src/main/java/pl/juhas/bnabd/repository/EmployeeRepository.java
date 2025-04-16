package pl.juhas.bnabd.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.juhas.bnabd.model.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query("SELECT e FROM Employee as e WHERE e.lastName LIKE CONCAT(:letter,'%') ")
    List<Employee> findEmployeeByLastNameStartingWith(@Param("letter") String letter);

}
