package ua.nure.test.project.javatest.menu;

import lombok.RequiredArgsConstructor;
import ua.nure.test.project.javatest.repository.DepartmentRepository;

import java.io.BufferedReader;
import java.io.IOException;

@RequiredArgsConstructor
public class WhoIsHeadAction implements MenuAction{
    private final DepartmentRepository depRepository;
    private final BufferedReader reader;

    @Override
    public void useAction() throws IOException {
        System.out.print("Who is head of department ");
        var depName = this.reader.readLine();

        var opDepartment = this.depRepository.findHeadByName(depName);

        if(opDepartment.isEmpty()){
            System.err.println("Head not found or department is not exists");
            return;
        }

        System.out.println("Head of %s department is %s".formatted(
                depName,
                opDepartment.get()
        ));
    }
}
