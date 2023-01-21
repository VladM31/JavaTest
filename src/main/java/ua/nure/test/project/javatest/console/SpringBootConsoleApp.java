package ua.nure.test.project.javatest.console;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.nure.test.project.javatest.exception.ExitException;
import ua.nure.test.project.javatest.menu.MenuItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SpringBootConsoleApp implements CommandLineRunner {
    private final static int ADD_VALUE_FOR_LAST_ELEMENT = 1;
    private final static int NUMBER_OF_INDENTS_FOR_CLEAR_CONSOLE = 15;
    private final static MenuItem EXIT = new MenuItem("Exit", () -> {
        throw new ExitException();
    });
    private final static MenuItem INCORRECT = new MenuItem("Incorrect", () -> {
        System.out.println("Incorrect choose");
        System.out.println();
    });

    private final Map<String, MenuItem> menuItems;
    private final BufferedReader reader;

    public SpringBootConsoleApp(List<MenuItem> menuItemList, BufferedReader reader) {
        this.reader = reader;
        this.menuItems = new HashMap<>();

        for (int i = 0; i < menuItemList.size(); i++) {
            menuItems.put(i + 1 + "", menuItemList.get(i));
        }
        menuItems.put(menuItemList.size() + ADD_VALUE_FOR_LAST_ELEMENT + "", EXIT);
    }

    private String choiceItem() throws IOException {
        this.menuItems.forEach((k, v) -> System.out.println("%s. %s".formatted(k, v.getName())));
        System.out.print("Input choice -> ");

        var item = this.reader.readLine();

        indents();

        return item;
    }

    public void indents() {
        this.indents(NUMBER_OF_INDENTS_FOR_CLEAR_CONSOLE);
    }

    public void indents(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println();
        }
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            String item = "";
            this.indents();

            while (true) {
                item = this.choiceItem();
                this.menuItems.getOrDefault(item, INCORRECT).getAction().useAction();
                this.indents(3);
            }
        } catch (ExitException e) {
            System.out.println("Exit");
        }
    }
}
