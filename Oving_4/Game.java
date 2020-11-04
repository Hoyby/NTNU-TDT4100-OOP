package app;

import java.util.Scanner;

public class Game {
	
	public Board board;
	public Player player1;
	public Player player2;
	
	public Game() {
		super();
		board = new Board(this);
		player1 = new Player();
		player2 = new Player();
	}
	
	
	
	public static void main(String[] args) {
		Game g2 = new Game();

		
		
		
		Game g1 = new Game();;
		System.out.println("write \"stop\" at any time to exit game.");
		while (true) {
			g1.board.printBoard();
			System.out.println(g1.board.getTile(2, 0));
			System.out.println("Choose row: ");
			Scanner input = new Scanner(System.in);
			String string = input.nextLine();
			System.out.println("Choose column: ");
			Scanner input2 = new Scanner(System.in);
			String string2 = input.nextLine();
			if (string.compareTo("stop") == 0) {
				break;
			}else {
				System.out.println(Integer.parseInt(string));
				g1.board.setTile(Integer.parseInt(string), Integer.parseInt(string2));
			}
		}
	}
}
