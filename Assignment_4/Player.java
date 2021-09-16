package app;

public class Player {
	private int score;
	private String name;
	

	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addScore() {
		this.score += 1;
	}
	
	public int getScore() {
		return score;
	}
	
	public Player() {
		super();
		this.name = "noName";
	}
}
