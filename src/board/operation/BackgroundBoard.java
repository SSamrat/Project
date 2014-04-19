package board.operation;

import ball.Ball;


public class BackgroundBoard {
	Box<Ball> box[][][];
	Ball ball;

	@SuppressWarnings("unchecked")
	public BackgroundBoard() {
		super();
		ball = new Ball('e');
		this.box = new Box[4][4][4];
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				for(int k=0; k<4; k++){
					box[i][j][k]=new Box<Ball>(ball);
				}
			}
		}
	}

	public Ball getBallInBox(int i, int j, int k) {
		return box[i][j][k].getObject();
	}

	public void setBallInBox(int i, int j, int k, Ball object) {
		this.box[i][j][k].setObject(object);
	}
	
	public void printBoard(){
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				for(int k=0; k<4; k++){
					System.out.print(box[i][j][k].getObject().getColor() + ", ");
				}
				System.out.print("\n    ");
			}
			System.out.println();
		}
	}
}
