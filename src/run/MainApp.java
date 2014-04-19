package run;

import playGame.ScoreFour;
import player.ActivePlayer;

public class MainApp {
	public static void main(String[] args) {
		ActivePlayer activePlayer1 = new ActivePlayer(1);
		ActivePlayer activePlayer2 = new ActivePlayer(2);
		
		new ScoreFour(activePlayer1, activePlayer2);
	}
}
