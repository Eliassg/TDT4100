package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import project.controller.ErrorController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(final Stage primaryStage) throws Exception {
		
		Thread.setDefaultUncaughtExceptionHandler(Main::showError);
		
		primaryStage.setTitle("Student Grade Register 3000");
		primaryStage.setScene(new Scene(FXMLLoader.load(Main.class.getResource("view/App.fxml"))));
		primaryStage.setResizable(false);
		primaryStage.setMinWidth(637);
		primaryStage.setMinHeight(800);
		primaryStage.show();
	}
	
/*
* Modified solution from stackoverflow thread about UncaughtExceptionHandler from: 
* https://stackoverflow.com/questions/26361559/general-exception-handling-in-javafx-8
*/
	
    private static void showError(Thread t, Throwable e) {
        System.err.println("***Default exception handler***");
        if (Platform.isFxApplicationThread()) {
            showErrorDialog(e);
        } else {
            System.err.println("An unexpected error occurred in "+t);
        }
    }

    public static void showErrorDialog(Throwable e) {
    	e = e.getCause();
    	// finding message which is relevant for user
    	String s = e.getMessage();
    	while (s == null) {
    		e = e.getCause();
    		s = e.getMessage();
    	}
    	
    	StringWriter errorMsg = new StringWriter();
        e.printStackTrace(new PrintWriter(errorMsg));
        System.err.print(errorMsg);
        Stage dialog = new Stage();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/Error.fxml"));
        try {
            Parent root = loader.load();
            ((ErrorController)loader.getController()).setErrorText(s);
            dialog.setScene(new Scene(root, 400, 100));
            dialog.show();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

	public static void main(final String[] args) {
		Main.launch(args);
	}
}