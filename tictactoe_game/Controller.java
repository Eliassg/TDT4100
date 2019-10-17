package app_oving;

import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;



public class Controller {
	
	@FXML Button bn1; 
	@FXML Button bn2;
	@FXML Button bn3;
	@FXML Button bn4;
	@FXML Button bn5;
	@FXML Button bn6;
	@FXML Button bn7;
	@FXML Button bn8;
	@FXML Button bn9;

	@FXML MenuItem mi2;
	
	@FXML Text scoreText;
	@FXML Text output;
	
	@FXML MenuBar menu;
	   
	@FXML GridPane gameBoard;
	
	ArrayList<Button> buttons  = new ArrayList<Button>();
	
	
	Turn player = new Turn();
	CheckWin winner = new CheckWin();
	app_IO io = new app_IO();
	
	
	public void click(ActionEvent evt) {
		Button bn = (Button) evt.getSource();
		bn.setText(player.determineTurn());
		bn.setDisable(true);
		System.out.println(bn);
		player.setColor(bn);
		if(winner.isWin(bn1,bn2,bn3,bn4,bn5,bn6,bn7,bn8,bn9)) {
			colorizeWin(winner.getWinningComb());
			winner.disableAll(bn1,bn2,bn3,bn4,bn5,bn6,bn7,bn8,bn9);
			player.updateScore();
			scoreText.setText( Integer.toString(player.getScoreX()) + " - " + Integer.toString(player.getScoreO()));
		}
		else {
		winner.isDraw(bn1,bn2,bn3,bn4,bn5,bn6,bn7,bn8,bn9);
		}
	}
	
	public void colorizeWin(int combination) {
		if(combination == 1) {
			bn1.setTextFill(Color.GREEN);
			bn2.setTextFill(Color.GREEN);
			bn3.setTextFill(Color.GREEN);
		}
		if(combination == 2) {
			bn4.setTextFill(Color.GREEN);
			bn5.setTextFill(Color.GREEN);
			bn6.setTextFill(Color.GREEN);
		}
		if(combination == 3) {
			bn7.setTextFill(Color.GREEN);
			bn8.setTextFill(Color.GREEN);
			bn9.setTextFill(Color.GREEN);
		}
		if(combination == 4) {
			bn1.setTextFill(Color.GREEN);
			bn4.setTextFill(Color.GREEN);
			bn7.setTextFill(Color.GREEN);
		}
		if(combination == 5) {
			bn2.setTextFill(Color.GREEN);
			bn5.setTextFill(Color.GREEN);
			bn8.setTextFill(Color.GREEN);
		}
		if(combination == 6) {
			bn3.setTextFill(Color.GREEN);
			bn6.setTextFill(Color.GREEN);
			bn9.setTextFill(Color.GREEN);
		}
		if(combination == 7) {
			bn1.setTextFill(Color.GREEN);
			bn5.setTextFill(Color.GREEN);
			bn9.setTextFill(Color.GREEN);
		}
		if(combination == 8) {
			bn3.setTextFill(Color.GREEN);
			bn5.setTextFill(Color.GREEN);
			bn7.setTextFill(Color.GREEN);
		}
	}
	
	public void resetGame() {
		buttons.add(bn1);
		buttons.add(bn2);
		buttons.add(bn3);
		buttons.add(bn4);
		buttons.add(bn5);
		buttons.add(bn6);
		buttons.add(bn7);
		buttons.add(bn8);
		buttons.add(bn9);
		for (Button button : buttons) {
			button.setDisable(false);
			button.setTextFill(Color.BLACK);
			button.setText("");
		}
		
	}
	
	public void save() {
		try {
			io.save("game.txt", player);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			output.setText("Could not save the game");
		}
	}
	
	public void load() {
		try {
			app_objectloader loader = io.load("game.txt");
			player = loader.player;
			scoreText.setText( Integer.toString(player.getScoreX()) + " - " + Integer.toString(player.getScoreO()));
			resetGame();
		} catch(IOException e) {
			output.setText("Filnavnet finnes ikke, sannsynligvis");
		}
	}	
	
}
