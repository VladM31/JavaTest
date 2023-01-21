package ua.nure.test.project.javatest.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MenuItem {
    private String name;
    private MenuAction action;
}
