package app_oving;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

	@Override
	public void start(final Stage primaryStage) throws Exception {
		primaryStage.setTitle("ULTIMATE TIC TAC TOE 3000");
		primaryStage.setScene(new Scene(FXMLLoader.load(App.class.getResource("App.fxml"))));
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(final String[] args) {
		App.launch(args);
	}
}