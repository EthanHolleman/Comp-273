
public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void changeX(int val) {
		x = x + val;
	}
	public void changeY(int val) {
		y = y + val;
	}
	
	public String toString() {
		String out = "(" +  this.x + "," + this.y + ")";
		return out;
	}
	
}
