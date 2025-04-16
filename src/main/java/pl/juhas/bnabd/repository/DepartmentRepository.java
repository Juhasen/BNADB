package pl.juhas.bnabd.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import pl.juhas.bnabd.model.Department;
import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

    @EntityGraph(attributePaths = "employees")
    List<Department> findAll();

    Department getFirstById(long id);

    Department getDepartmentByName(String name);
}
