package app_rev2;

import java.util.Collection;

public class Game {
	
	public Board board;
	public Player player1;
	public Player player2;
	public IOInterface IO;
	private Collection<Player> players = Player.getPlayers();
	
	public Game() {
		super();
		board = new Board(this);
		IO = new IO();
	}
	
}
