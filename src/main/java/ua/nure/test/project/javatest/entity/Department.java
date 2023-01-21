package ua.nure.test.project.javatest.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "departments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "head_of_department_name", nullable = false)
    private String headOfDepartmentName;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "departments_id", referencedColumnName = "id")
    private Set<LinkToLector> links;
}
