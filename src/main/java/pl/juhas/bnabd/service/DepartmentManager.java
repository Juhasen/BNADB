package pl.juhas.bnabd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.juhas.bnabd.entity.Department;
import pl.juhas.bnabd.repository.DepartmentRepository;

@Service
public class DepartmentManager {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentManager(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

}
