package app_oving;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class CheckWin {	

	int WinningComb = 0; 

	public CheckWin() {
		
	}
	
	public boolean isWin(Button first, Button second, Button third, Button fourth,
			Button fifth, Button sixth, Button seventh, Button eighth,  Button nineth) {
		//Rad 1
		if (""!=first.getText() && first.getText().equals(second.getText()) 
			&& second.getText().equals(third.getText())){
			WinningComb = 1;
			return true;
		}
		//rad 2
		if (""!=fourth.getText() && fourth.getText().equals(fifth.getText()) 
			&& fifth.getText().equals(sixth.getText())){
			WinningComb = 2;
			return true;
		//rad 3
		}
		if (""!=seventh.getText() && seventh.getText().equals(eighth.getText()) 
			&& eighth.getText().equals(nineth.getText())){
			WinningComb = 3;
			return true;
			}
		//kolonne 1
		if (""!=first.getText() && first.getText().equals(fourth.getText()) 
			&& fourth.getText().equals(seventh.getText())){
			WinningComb = 4;
			return true;
			}
		//kolonne 2
		if (""!=second.getText() && second.getText().equals(fifth.getText()) 
			&& fifth.getText().equals(eighth.getText())){
			WinningComb = 5;
			return true;
			}
		//kolonne 3
		if (""!=third.getText() && third.getText().equals(sixth.getText()) 
			&& sixth.getText().equals(nineth.getText())){
			WinningComb = 6;
			return true;
				}
		//diagonal 1
		if (""!=first.getText() && first.getText().equals(fifth.getText()) 
			&& fifth.getText().equals(nineth.getText())){
			WinningComb = 7;
			return true;
			}
		//diagonal 2
		if (""!=third.getText() && third.getText().equals(fifth.getText()) 
			&& fifth.getText().equals(seventh.getText())){
			WinningComb = 8;
			return true;
			}
		
		 return false;
	}
	
	public void disableAll(Button first, Button second, Button third, Button fourth,
			Button fifth, Button sixth, Button seventh, Button eighth,  Button nineth){
		first.setDisable(true);
		second.setDisable(true);
		third.setDisable(true);
		fourth.setDisable(true);
		fifth.setDisable(true);
		sixth.setDisable(true);
		seventh.setDisable(true);
		eighth.setDisable(true);
		nineth.setDisable(true);
	}

	public void isDraw(Button first, Button second, Button third, Button fourth,
			Button fifth, Button sixth, Button seventh, Button eighth,  Button nineth) {
		if(!first.getText().equals("") && !second.getText().equals("") && !third.getText().equals("")
			&& !fourth.getText().equals("") && !fifth.getText().equals("") && !sixth.getText().equals("")
			&& !seventh.getText().equals("") && !eighth.getText().equals("") && !nineth.getText().equals("")) {
			first.setTextFill(Color.YELLOW);
			second.setTextFill(Color.YELLOW);
			third.setTextFill(Color.YELLOW);
			fourth.setTextFill(Color.YELLOW);
			fifth.setTextFill(Color.YELLOW);
			sixth.setTextFill(Color.YELLOW);
			seventh.setTextFill(Color.YELLOW);
			eighth.setTextFill(Color.YELLOW);
			nineth.setTextFill(Color.YELLOW);
		}
	}
	
	public int getWinningComb() {
		return WinningComb;
	}

	public static void main(String[] args) {
	}
}

