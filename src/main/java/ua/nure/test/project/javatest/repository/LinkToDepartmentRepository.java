package ua.nure.test.project.javatest.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import ua.nure.test.project.javatest.entity.LinkToDepartment;

import java.util.Optional;

public interface LinkToDepartmentRepository extends Repository<LinkToDepartment, Long> {
    @Query("SELECT AVG(l.salary) FROM ua.nure.test.project.javatest.entity.LinkToDepartment l WHERE l.department.name = :name")
    Optional<Double> findAvgSalaryByName(@Param("name") String name);

    @Query("SELECT COUNT(l) FROM ua.nure.test.project.javatest.entity.LinkToDepartment l WHERE l.department.name = :name")
    Optional<Long> findCountByName(@Param("name") String name);
}
