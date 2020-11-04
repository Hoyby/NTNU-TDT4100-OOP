package app_rev2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Player implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int score;
	private String name;
	private static Collection<Player> players = new ArrayList<>();
	

	
	public String getName() {
		return name;
	}
	

	
	public void addScore() {
		this.score += 1;
	}
	
	public int getScore() {
		return score;
	}
	
	public Player(String name) throws IllegalArgumentException {
		super();
		this.score = 0;
		if(nameOk(name)) {
			this.name = name;
			players.add(this);
		}
	}
	
	public static Collection<Player> getPlayers() {
		return players;
	}
	
	public static Boolean nameOk(String name) {
		if(name.length() < 2 || name.length() > 16) {
			throw new IllegalArgumentException("Name must be 2-16 characters.");
		}else if (!name.matches("[a-zA-Z]{2,16}")) {
			throw new IllegalArgumentException("Name must contain only letters.");
		}
		return true;
		
	}
	
	public static void main(String[] args) throws IllegalArgumentException {
		Player p1 = new Player("alex");
		System.out.println(p1.getScore());
	}
}
