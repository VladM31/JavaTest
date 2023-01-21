package ua.nure.test.project.javatest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "link_to_department")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkToLector {
    @EmbeddedId
    private LinkId id;
    @Column(name = "salary",nullable = false)
    private int salary;
    @ManyToOne()
    @JoinColumn(name="lectors_id", nullable=false, insertable = false, updatable = false)
    private Lector lector;
}
