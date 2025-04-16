package pl.juhas.bnabd.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.juhas.bnabd.entity.Department;
import pl.juhas.bnabd.service.DepartmentManager;

@RestController
@RequestMapping("/api/departments")
public class DepartmentApi {

    private final DepartmentManager departmentManager;

    public DepartmentApi(DepartmentManager departmentManager) {
        this.departmentManager = departmentManager;
    }

    @PostMapping("/add")
    public Department addDepartment(@RequestBody Department department) {
        return departmentManager.save(department);
    }

}
