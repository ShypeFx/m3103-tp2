package m3103.tp3;

public class Cellule {
	
	private int x;
	private int y;
	
	public Cellule(int x1, int y1) {
		this.x = x1;
		this.y = y1;
	}
	
	public int[] toArray() {
		return new int [] {x,y};
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
