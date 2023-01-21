package ua.nure.test.project.javatest.menu;

import lombok.RequiredArgsConstructor;
import ua.nure.test.project.javatest.enumeration.Degree;
import ua.nure.test.project.javatest.repository.DepartmentRepository;

import java.io.BufferedReader;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ShowStatisticsAction implements MenuAction {
    private static final Long EMPTY = 0L;
    private final DepartmentRepository repository;
    private final BufferedReader reader;

    @Override
    public void useAction() throws Exception {
        System.out.print("Show statistics of department ");
        var depName = reader.readLine();

        var opDepartment = repository.findByName(depName);

        if (opDepartment.isEmpty()) {
            System.err.println("Department is not found");
            return;
        }

        var map = opDepartment.get().getLinks().stream()
                .collect(Collectors.groupingBy(
                        (l) -> l.getLector().getDegree(),
                        Collectors.counting()
                ));

        for (var degree : Degree.values()) {
            if (!map.containsKey(degree)) {
                map.put(degree, EMPTY);
            }
        }

        map.forEach((k, v) -> System.out.println(k + " - " + v));
    }
}
