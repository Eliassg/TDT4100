package app_oving;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class Turn {
	
	public String whoseTurn = "O";
	public int scoreX = 0;
	public int scoreO = 0;
	
	public Turn() {
	}
	
	public Turn(int x, int o) {
		this.scoreX = x;
		this.scoreO = o;
	}
	
	public String determineTurn() {
		if (whoseTurn.equalsIgnoreCase("O")) {
			whoseTurn = "X";
		}
		else {
			whoseTurn = "O";
		}
		return whoseTurn;
	}
	
	
	public void setColor(Button button) {
		if (whoseTurn.equalsIgnoreCase("X")) {
			button.setTextFill(Color.BLUE);
		}
		else {
			button.setTextFill(Color.RED);
		}
	}
	
	public static void main(String [] args) {
		Turn p = new Turn();
		p.determineTurn();
	}
	
	public int getScoreX() {
		return this.scoreX;
	}
	
	public int getScoreO() {
		return this.scoreO;
	}
	
	
	public void updateScore() {
		if(whoseTurn.equals("X")) {
			this.scoreX +=1;
		}
		else {
			this.scoreO +=1;
		}
	}
	
	
}
