package playGame;

import board.gui.Board3D;
import board.operation.BackgroundBoard;
import player.*;

/*
 * ScoreFour Class
 * 
 * This class handles execution of the game.  
 * The constructor accepts two player instances, which will make moves in the game.
 * The ScoreFour class will deal with those moves and determine whether a move is legal
 * (see isValidCoordinate, isValidPlacement and place methods), and after each move
 * whether the game is over (see isGameOVer).
 * 
 * In the comments below, i is the row number, j is the column number, and k is the height.
 */
public class ScoreFour {
	ActivePlayer player1, player2;
	Board3D gui;
	BackgroundBoard backgroundBoard;
	
	
	/**
	 * #1
	 * 
	 * Initialize all instance variables (e.g. players, board ... )
	 * @param player1 - first player
	 * @param player2 - second player
	 */
	@SuppressWarnings("static-access")
	public ScoreFour(ActivePlayer player1, ActivePlayer player2) {
		// TODO fill in this method
		this.player1 = player1;
		this.player2 = player2;
		
		backgroundBoard = new BackgroundBoard();
		
		
		guiBuilder();
		
		
		int TimeCounter=0;
		while(!isGameOver() && !isFull()){
			while(TimeCounter<70){
				try {
					Thread.currentThread().sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(gui.getMoveGiven()){
					break;
				}
				TimeCounter++;
				
				gui.setJLabelMessage((70-TimeCounter) + "");
			}
			
			if(TimeCounter>=70){
				gui.changePlayer();
			}
			
			TimeCounter=0;
			gui.setMoveGiven(false);
		}
		
		int Outcome=0;
		
		if(isFull()){
			Outcome=1;
		}
		
		gui.notify("Game Over", Outcome);
		
	}
	
	/**
	 * #2
	 * 
	 * Check if the coordinates are valid
	 * 
	 * Coordinates are valid if and only if they are:
	 * 		* greater than or equal to 0
	 * and	* less than boardSize
	 * 
	 * @param i - i coordinate
	 * @param j - j coordinate
	 * @param k - k coordinate
	 * @return true - if coordinates are valid
	 * @return false - if coordinates are invalid
	 */
	protected boolean isValidCoordinate(int i, int j, int k) {
		// TODO fill in this method
		return true;
	}
	
	/**
	 * #3
	 * 
	 * Get the value of the board at (i, j, k).
	 * 
	 * The value of the board is a single char: use 'w' for WHITE, representing player 1, 
	 * and 'b' for BLACK, representing player 2.
	 * 
	 * return -1 if the coordinates are invalid
	 * return 0 (without quotes) if the board is empty at the given coordinates.
	 * 
	 * NOTE: All other methods require this method to be working for testing.
	 * 
	 * @param i - i coordinate
	 * @param j - j coordinate
	 * @param k - k coordinate
	 * @return value
	 */
	protected char getValue(int i, int j, int k) {
		// TODO fill in this method
		return backgroundBoard.getBallInBox(i, j, k).getColor();
	}
	
	/**
	 * #3
	 * 
	 * Set the value of the board at (i, j, k)
	 * 
	 * if the coordinates are invalid, do nothing
	 * 
	 * NOTE: All other methods require this method to be working for testing.
	 * 
	 * @param i - i coordinate
	 * @param j - j coordinate
	 * @param k - k coordinate
	 * @param value - the new value
	 */
	protected void setValue(int i, int j, int k, char value) {	
		// TODO fill in this method
	}
	
	/**
	 * #4
	 * 
	 * Check if the placement is Valid
	 * 
	 * The placement is valid if and only if:
	 * 		* the coordinates are valid
	 * and	* the column is not full
	 * 
	 * @param placement - the position of the placement
	 * @return true - if the placement is valid
	 * @return false - if the placement is invalid
	 */
	protected boolean isValidPlacement(Coordinate placement) {
		// TODO fill in this method
		return false;
	}
	
	/**
	 * #5
	 * 
	 * Place a value at the coordinate
	 * 
	 * If the position is invalid, ignore it.
	 *  
	 * @param position - the position of the placement
	 * @param value - the value ('b'/'w')
	 */
	protected void place(Coordinate placement, char value) {
		// TODO fill in this method
	}
	
	/**
	 * #6
	 * 
	 * Check if the game is over.
	 * 
	 * The game is over if and only if:
	 * 		* 64 moves have been attempted (valid or invalid) and neither player has 
	 * 		won;
	 * or		* a player has won.
|	 * 
	 * A player has won if and only if:
	 * 		* they have boardSize pieces in a row (horizontal, vertical or diagonal)
	 * 	
	 * @return
	 */
	protected boolean isGameOver() {
		// TODO fill in this method
		
		int j, k; 	
		
		/////////////////*******straight*******/////////////////
		for(k=0; k<4; k++){					//_horizontal_	2D
			for(j=0; j<4; j++){
				if(backgroundBoard.getBallInBox(j, k, 0).getColor()==backgroundBoard.getBallInBox(j, k, 1).getColor() &&
						backgroundBoard.getBallInBox(j, k, 1).getColor()==backgroundBoard.getBallInBox(j, k, 2).getColor() &&
						backgroundBoard.getBallInBox(j, k, 2).getColor()==backgroundBoard.getBallInBox(j, k, 3).getColor() &&
						backgroundBoard.getBallInBox(j, k, 3).getColor()!='e'){
					return true;
				}
			}
		}
		for(k=0; k<4; k++){					//|_vertical-horizontal_|	2D
			for(j=0; j<4; j++){
				if(backgroundBoard.getBallInBox(j, 0, k).getColor()==backgroundBoard.getBallInBox(j, 1, k).getColor() &&
						backgroundBoard.getBallInBox(j, 1, k).getColor()==backgroundBoard.getBallInBox(j, 2, k).getColor() &&
						backgroundBoard.getBallInBox(j, 2, k).getColor()==backgroundBoard.getBallInBox(j, 3, k).getColor() &&
						backgroundBoard.getBallInBox(j, 3, k).getColor()!='e'){
					return true;
				}
			}
		}
		for(k=0; k<4; k++){						//|vertical|	3D
			for(j=0; j<4; j++){
				if(backgroundBoard.getBallInBox(0, j, k).getColor()==backgroundBoard.getBallInBox(1, j, k).getColor() &&
						backgroundBoard.getBallInBox(1, j, k).getColor()==backgroundBoard.getBallInBox(2, j, k).getColor() &&
						backgroundBoard.getBallInBox(2, j, k).getColor()==backgroundBoard.getBallInBox(3, j, k).getColor() &&
						backgroundBoard.getBallInBox(3, j, k).getColor()!='e'){
					return true;
				}
			}
		}
		
		////////////////********diagonal********/////////////////
		for(k=0; k<4; k++){						//simple diagonal		2D
			if(backgroundBoard.getBallInBox(k, 0, 0).getColor()==backgroundBoard.getBallInBox(k, 1, 1).getColor() &&
					backgroundBoard.getBallInBox(k, 1, 1).getColor()==backgroundBoard.getBallInBox(k, 2, 2).getColor() &&
					backgroundBoard.getBallInBox(k, 2, 2).getColor()==backgroundBoard.getBallInBox(k, 3, 3).getColor() &&
					backgroundBoard.getBallInBox(k, 3, 3).getColor()!='e'){
				return true;
			}
			if(backgroundBoard.getBallInBox(k, 3, 0).getColor()==backgroundBoard.getBallInBox(k, 2, 1).getColor() &&
					backgroundBoard.getBallInBox(k, 2, 1).getColor()==backgroundBoard.getBallInBox(k, 1, 2).getColor() &&
					backgroundBoard.getBallInBox(k, 1, 2).getColor()==backgroundBoard.getBallInBox(k, 0, 3).getColor() &&
					backgroundBoard.getBallInBox(k, 0, 3).getColor()!='e'){
				return true;
			}
		}
		for(k=0; k<4; k++){						//side diagonal		3D
			if(backgroundBoard.getBallInBox(0, 0, k).getColor()==backgroundBoard.getBallInBox(1, 1, k).getColor() &&
					backgroundBoard.getBallInBox(1, 1, k).getColor()==backgroundBoard.getBallInBox(2, 2, k).getColor() &&
					backgroundBoard.getBallInBox(2, 2, k).getColor()==backgroundBoard.getBallInBox(3, 3, k).getColor() &&
					backgroundBoard.getBallInBox(3, 3, k).getColor()!='e'){
				return true;
			}
			if(backgroundBoard.getBallInBox(3, 0, k).getColor()==backgroundBoard.getBallInBox(2, 1, k).getColor() &&
					backgroundBoard.getBallInBox(2, 1, k).getColor()==backgroundBoard.getBallInBox(1, 2, k).getColor() &&
					backgroundBoard.getBallInBox(1, 2, k).getColor()==backgroundBoard.getBallInBox(0, 3, k).getColor() &&
					backgroundBoard.getBallInBox(0, 3, k).getColor()!='e'){
				return true;
			}
		}
		for(k=0; k<4; k++){						//front diagonal		3D
			if(backgroundBoard.getBallInBox(0, k, 0).getColor()==backgroundBoard.getBallInBox(1, k, 1).getColor() &&
					backgroundBoard.getBallInBox(1, k, 1).getColor()==backgroundBoard.getBallInBox(2, k, 2).getColor() &&
					backgroundBoard.getBallInBox(2, k, 2).getColor()==backgroundBoard.getBallInBox(3, k, 3).getColor() &&
					backgroundBoard.getBallInBox(3, k, 3).getColor()!='e'){
				return true;
			}
			if(backgroundBoard.getBallInBox(3, k, 0).getColor()==backgroundBoard.getBallInBox(2, k, 1).getColor() &&
					backgroundBoard.getBallInBox(2, k, 1).getColor()==backgroundBoard.getBallInBox(1, k, 2).getColor() &&
					backgroundBoard.getBallInBox(1, k, 2).getColor()==backgroundBoard.getBallInBox(0, k, 3).getColor() &&
					backgroundBoard.getBallInBox(0, k, 3).getColor()!='e'){
				return true;
			}
		}
		
		/////////////////******diagonal-diagonal*******///////////////
		if(backgroundBoard.getBallInBox(0, 0, 0).getColor()==backgroundBoard.getBallInBox(1, 1, 1).getColor() &&
				backgroundBoard.getBallInBox(1, 1, 1).getColor()==backgroundBoard.getBallInBox(2, 2, 2).getColor() &&
				backgroundBoard.getBallInBox(2, 2, 2).getColor()==backgroundBoard.getBallInBox(3, 3, 3).getColor() &&
				backgroundBoard.getBallInBox(3, 3, 3).getColor()!='e'){
			return true;
		}
		if(backgroundBoard.getBallInBox(0, 0, 3).getColor()==backgroundBoard.getBallInBox(1, 1, 2).getColor() &&
				backgroundBoard.getBallInBox(1, 1, 2).getColor()==backgroundBoard.getBallInBox(2, 2, 1).getColor() &&
				backgroundBoard.getBallInBox(2, 2, 1).getColor()==backgroundBoard.getBallInBox(3, 3, 0).getColor() &&
				backgroundBoard.getBallInBox(3, 3, 0).getColor()!='e'){
			return true;
		}
		
		
		return false;
	}
	
	/**
	 * Run the game and return the winning player
	 * 		1. Notify players of new opoonent (use the opponent's class' canonical name)
	 * 		2. Run the game until the game is over
	 * 		3. Notify players of outcome (possible outcomes are WIN, DRAW, LOSS
	 * 		4. Return winning player (return null for a draw)
	 * 
	 * 
	 * @return winning player
	 * @return null - if there's a draw
	 */
	public Player run() {
		// TODO fill in this method
		return null;
	}
	
	
	//players' input field
	public void guiBuilder(){
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Board3D.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Board3D.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Board3D.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Board3D.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /* Create and display the form */
        gui = new Board3D(player1, player2, backgroundBoard);
        gui.setVisible(true);
	}
	
	
	//see if box is full
	public boolean isFull(){
		int full=1;
		
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				if(backgroundBoard.getBallInBox(0, i, j).getColor()=='e'){
					full=0;
				}
			}
		}
		
		if(full==1){
			return true;
		}
		
		
		return false;
	}
	
	
}
