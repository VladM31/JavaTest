package ua.nure.test.project.javatest.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import ua.nure.test.project.javatest.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends Repository<Department, Long> {

    @Query("SELECT d.headOfDepartmentName FROM ua.nure.test.project.javatest.entity.Department d WHERE d.name = :name")
    Optional<String> findHeadByName(@Param("name") String name);

    Optional<Department> findByName(String name);

    @Query(value = "SELECT CONCAT(d.name, ' - ', d.headOfDepartmentName)  FROM ua.nure.test.project.javatest.entity.Department d " +
            "WHERE d.name LIKE CONCAT('%',:str,'%') OR d.headOfDepartmentName LIKE CONCAT('%',:str,'%') ")
    List<String> findGlobal(String str);
}
