package com.menu;

import java.sql.SQLException;

public class DeleteCommand implements Command {
    @Override
    public void execute() throws SQLException {
        Main.deleteGift();
    }
}
