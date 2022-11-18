package com.menu;

import java.sql.SQLException;
import java.util.*;

public class MainMenu {
    private Map<String, Command> MenuItems;

    public MainMenu(){
        MenuItems = new LinkedHashMap<>();
        MenuItems.put("info", new InfoCommand());
        MenuItems.put("create", new CreateCommand());
        MenuItems.put("check", new CheckCommand());
        MenuItems.put("delete", new DeleteCommand());
        MenuItems.put("sort", new SortCommand());
        MenuItems.put("exit", new ExitCommand());
    }
    public void execute(String command) throws SQLException {
        MenuItems.getOrDefault(command, () -> System.out.println("Incorrect command")).execute();
    }
    public Set<String> getCommands(){
        return  MenuItems.keySet();
    }
}
