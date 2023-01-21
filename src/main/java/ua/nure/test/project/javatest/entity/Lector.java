package ua.nure.test.project.javatest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.nure.test.project.javatest.enumeration.Degree;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "lectors")
@Table(name = "lectors")
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "degree", nullable = false)
    private Degree degree;
    @Column(name="first_name", nullable = false, length = 60)
    private String firstName;
    @Column(name="last_name", nullable = false, length = 60)
    private String lastName;
    @Column(name="birth_date", nullable = false)
    private LocalDate birthDate;
}
