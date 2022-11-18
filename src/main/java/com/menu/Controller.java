package com.menu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button checkButton;

    @FXML
    private Button createButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button infoButton;

    @FXML
    private Button sortButton;

    @FXML
    void initialize() {
        assert checkButton != null : "fx:id=\"checkButton\" was not injected: check your FXML file 'app.fxml'.";
        assert createButton != null : "fx:id=\"createButton\" was not injected: check your FXML file 'app.fxml'.";
        assert deleteButton != null : "fx:id=\"deleteButton\" was not injected: check your FXML file 'app.fxml'.";
        assert exitButton != null : "fx:id=\"exitButton\" was not injected: check your FXML file 'app.fxml'.";
        assert infoButton != null : "fx:id=\"infoButton\" was not injected: check your FXML file 'app.fxml'.";
        assert sortButton != null : "fx:id=\"sortButton\" was not injected: check your FXML file 'app.fxml'.";

    }

}

