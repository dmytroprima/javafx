package com.menu;

import java.sql.SQLException;

public interface Command {
    void execute() throws SQLException;
}
