package stateandbehavior;

public class Location {

	int x;
	int y;
	
	public void up() {
		y --;
	}
	
	public void down() {
		y ++;
	}
	
	public void left() {
		x --;
	}
	
	public void right() {
		x ++;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String toString() {
		return "x: " + x + "\n" + "y: " + y;
	}
	
	public Location() {
		super();
		this.x = 0;
		this.y = 0;
	}

	public static void main(String[] args) {
	Location l1 = new Location();
	l1.down();
	l1.down();
	l1.down();
	l1.right();
	l1.right();
	l1.right();
	l1.right();
	l1.left();
	l1.up();
	System.out.println(l1.toString());
	}

}
