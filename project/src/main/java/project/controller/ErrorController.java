package project.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/*
 * Modified solution from stackoverflow thread about UncaughtExceptionHandler from: 
 * https://stackoverflow.com/questions/26361559/general-exception-handling-in-javafx-8
 */

public class ErrorController {
    @FXML
    private Label errorMessage ;

    public void setErrorText(String text) {
        errorMessage.setText(text);
    }

    @FXML
    private void close() {
        errorMessage.getScene().getWindow().hide();
    }
}
