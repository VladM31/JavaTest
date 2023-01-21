package ua.nure.test.project.javatest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkId implements Serializable {
    @Column(name = "departments_id", nullable = false)
    private Long departmentId;

    @Column(name = "lectors_id", nullable = false)
    private Long lectorsId;
}
