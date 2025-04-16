package pl.juhas.bnabd.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private String firstName;

    private String lastName;

    private BigDecimal salary;

    @Version
    @Column(name = "OPTLOCK")
    private int versionNum;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
