package ua.nure.test.project.javatest.menu;

import lombok.RequiredArgsConstructor;
import ua.nure.test.project.javatest.repository.LinkToDepartmentRepository;

import java.io.BufferedReader;

@RequiredArgsConstructor
public class ShowAverageSalaryForDepAction implements MenuAction {
    private final LinkToDepartmentRepository repository;
    private final BufferedReader reader;

    @Override
    public void useAction() throws Exception {
        System.out.print("Show the average salary for the department ");
        var depName = reader.readLine();

        var opAvg = this.repository.findAvgSalaryByName(depName);

        if (opAvg.isEmpty()) {
            System.err.println("Department is not found");
            return;
        }

        System.out.println("The average salary of %s is %s".formatted(depName, opAvg.get()));
    }
}
