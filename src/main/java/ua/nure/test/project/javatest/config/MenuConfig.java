package ua.nure.test.project.javatest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.nure.test.project.javatest.menu.*;
import ua.nure.test.project.javatest.repository.DepartmentRepository;
import ua.nure.test.project.javatest.repository.LectorRepository;
import ua.nure.test.project.javatest.repository.LinkToDepartmentRepository;

import java.io.BufferedReader;

@Configuration
public class MenuConfig {

    @Bean
    MenuItem whoIsHeadOfDepartmentMenu(DepartmentRepository repository, BufferedReader reader) {
        return new MenuItem(
                "Who is head of department {department_name}",
                new WhoIsHeadAction(repository, reader)
        );
    }

    @Bean
    MenuItem showDepartmentStatistic(DepartmentRepository repository, BufferedReader reader) {
        return new MenuItem(
                "Show statistics of department {department_name} ",
                new ShowStatisticsAction(repository, reader)
        );
    }

    @Bean
    MenuItem showTheAverageSalaryForTheDepartment(LinkToDepartmentRepository repository, BufferedReader reader) {
        return new MenuItem(
                "Show the average salary for the department {department_name}",
                new ShowAverageSalaryForDepAction(repository, reader)
        );
    }

    @Bean
    MenuItem showCountOfEmployeeForTheDepartment(LinkToDepartmentRepository repository, BufferedReader reader) {
        return new MenuItem(
                "Show count of employee for {department_name}",
                new ShowCountOfEmployee(repository, reader)
        );
    }

    @Bean
    MenuItem globalSearchByTemplate(DepartmentRepository departmentRepository,
                                    LectorRepository lectorRepository,
                                    BufferedReader reader) {
        return new MenuItem(
                "Global search by {template}",
                new GlobalSearchAction(departmentRepository, lectorRepository, reader)
        );
    }
}


