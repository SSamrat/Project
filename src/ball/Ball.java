package ball;

public class Ball {
	private char color;	//e=no ball, w=white ball, b=black ball

	public Ball(char ballColor) {
		super();
		this.color = ballColor;
	}

	public char getColor() {
		return color;
	}

	public void setColor(char ballColor) {
		this.color = ballColor;
	}
}
