package pl.juhas.bnabd.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Employee> employees;

    private String name;
    private String description;
    private String location;


    public Department(String name, String description, String location) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.employees = new ArrayList<>();
    }

    public Department() {
    }

    public Long getId() {
        return id;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", employees=" + employees + ", name=" + name;
    }
}
