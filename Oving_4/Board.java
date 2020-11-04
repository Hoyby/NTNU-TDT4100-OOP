package app;

public class Board {

	private enum State{X,O}
	private Game game;
	private State[][] board;
	private Boolean isWin = false;
	private Boolean isDraw = false;
	
	public Boolean getIsWin() {
		return isWin;
	}
	public Boolean getIsDraw() {
		return isDraw;
	}
	
	private int moveCount;
	int n = 3;
	
	public int getMoveCount() {
		return moveCount;
	}
	
	public void clearBoard() {
		for(int x = 0; x < n; x++) {
			for(int i = 0; i < n; i++) {
				board[i][x] = null;
			}
		}
		moveCount = 0;
		isWin = false;
		isDraw = false;
	}
	
	public Board(Game game){
		super();
		this.game = game;
		board = new State[n][n];
	}
	
	public void printBoard(){
//		Returns the current state of the game as a grid
		for(int x = 0; x < n; x++) {
			for(int i = 0; i < n; i++) {
				System.out.print(board[x][i]);
			}
			System.out.println(" ");
		}
		System.out.println(" ");
	}
	
	public Object getTile(int row, int column) {
//		Returns the state of a specified tile
		return board[row][column];
	}
	
	public void setTile(int row, int column) {
//		Sets a tile if the tile is on the board, and the symbol are correct, the tile is not taken, and it's your turn.
		if (row < 0 && row > board[column].length) {
			throw new IllegalArgumentException("Not a valid tile");
		}else if (board[row][column] != null) {
			throw new IllegalArgumentException("Tile is already occupied");
		}
		
		if (moveCount % 2 == 0) {
			board[row][column] = State.X;
			System.out.println("X, set to " + row + ", " + column);
		}else {
			board[row][column] = State.O;
			System.out.println("O, set to " + row + ", " + column);
		}
		
		State mark = board[row][column];
		moveCount ++;
		
//		Checks if the state of the board is a winning state.
//		Rows
		for (int i = 0; i < n; i++) {
			if (board[row][i] != mark)
				break;
			if (i == n - 1) {
				isWin = true;
				if (!(getMoveCount() % 2 == 0)) {
					game.player1.addScore();
				}else {
					game.player2.addScore();
				}
			}
		}
			
//		Columns
		for (int i = 0; i < n; i++) {
			if (board[i][column] != mark)
				break;
			if (i == n - 1) {
				isWin = true;
				if (!(getMoveCount() % 2 == 0)) {
					game.player1.addScore();
				}else {
					game.player2.addScore();
				}
			}
		}
		
//		Diagonal
		if(row==column) {
			for (int i = 0; i < n; i++) {
				if (board[i][i] != mark)
					break;
				if (i == n - 1) {
					isWin = true;
					if (!(getMoveCount() % 2 == 0)) {
						game.player1.addScore();
					}else {
						game.player2.addScore();
					}
				}
			}
		}
			
//		Reverse diagonal
		if((row + column) == (n-1)) {
			for (int i = 0; i < n; i++) {
				if (board[i][(n - 1) - i] != mark)
					break;
				if (i == n - 1) {
					isWin = true;
					if (!(getMoveCount() % 2 == 0)) {
						game.player1.addScore();
					}else {
						game.player2.addScore();
					}
				}
			}
		}
		
//		Draw
		if(moveCount == (Math.pow(n, 2))) {
			isDraw = true;
		}		
	}
	
	
	}
	
//}
