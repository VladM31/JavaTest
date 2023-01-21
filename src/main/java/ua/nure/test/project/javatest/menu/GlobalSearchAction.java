package ua.nure.test.project.javatest.menu;

import lombok.RequiredArgsConstructor;
import ua.nure.test.project.javatest.repository.DepartmentRepository;
import ua.nure.test.project.javatest.repository.LectorRepository;

import java.io.BufferedReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class GlobalSearchAction implements MenuAction{
    private final DepartmentRepository departmentRepository;
    private final LectorRepository lectorRepository;
    private final BufferedReader reader;

    @Override
    public void useAction() throws Exception {
        System.out.print("Global search by ");
        var template = reader.readLine();

        var result = Stream.concat(
                departmentRepository.findGlobal(template).stream(),
                lectorRepository.findGlobal(template).stream()
        ).collect(
                Collectors.joining(", ")
        );

        System.out.println(result);
    }
}
