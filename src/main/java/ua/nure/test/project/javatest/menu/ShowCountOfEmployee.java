package ua.nure.test.project.javatest.menu;

import lombok.RequiredArgsConstructor;
import ua.nure.test.project.javatest.repository.LinkToDepartmentRepository;

import java.io.BufferedReader;

@RequiredArgsConstructor
public class ShowCountOfEmployee implements MenuAction{
    private final LinkToDepartmentRepository repository;
    private final BufferedReader reader;

    @Override
    public void useAction() throws Exception {
        System.out.print("Show count of employee for ");
        var depName = reader.readLine();

        var opCount = repository.findCountByName(depName);

        if (opCount.isEmpty()) {
            System.err.println("Department is not found");
            return;
        }

        System.out.println("Employee count %s".formatted(opCount.get()));
    }
}
