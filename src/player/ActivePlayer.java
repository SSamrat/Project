package player;

import ball.Ball;
import board.operation.BackgroundBoard;

public class ActivePlayer implements Player{
	private int playerNo;
	private char ballColor;
	
	public ActivePlayer(int playerNo) {
		this.playerNo = playerNo;
		
		if(playerNo==1){
			ballColor='w';
		}else{
			ballColor='b';
		}
	}
	
	@Override
	public Coordinate getNextMove(char[][][] board, char colour) {
		
		return null;
	}

	@Override
	public void notifyNewOpponent(String opponentName) {
		
	}

	@Override
	public void notifyOutcome(String outcome) {
		
	}
	
	public void giveNextMove(BackgroundBoard backgroundBoard, int i, int j, int k){
		Ball ball = new Ball(ballColor);
		
		backgroundBoard.setBallInBox(i, j, k, ball);
		
	}
	
	public int getPlayerNo() {
		return playerNo;
	}
}
