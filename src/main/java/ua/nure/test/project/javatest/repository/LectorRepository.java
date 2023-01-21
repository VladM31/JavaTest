package ua.nure.test.project.javatest.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import ua.nure.test.project.javatest.entity.Lector;

import java.util.List;

public interface LectorRepository extends Repository<Lector, Long> {

    @Query(value = "SELECT CONCAT(l.firstName,' ',l.lastName) AS fullName FROM ua.nure.test.project.javatest.entity.Lector l " +
            "WHERE l.firstName LIKE CONCAT('%',:str,'%') OR l.lastName LIKE CONCAT('%',:str,'%') ")
    List<String> findGlobal(String str);
}
