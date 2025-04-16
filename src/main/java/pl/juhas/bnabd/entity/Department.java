package pl.juhas.bnabd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.List;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Employee> employees;

    private String name;
    private String description;
    private String location;

    public Department(String name, String description, String location) {
        this.name = name;
        this.description = description;
        this.location = location;
    }


    @Override
    public String toString() {
        return "Department [id=" + id + ", employees=" + employees + ", name=" + name;
    }
}
