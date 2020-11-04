package app_rev2;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class GameController {
	
	Game game;
	private int localScore1 = 0;
	private int localScore2 = 0;
	
	@FXML Button tl;
	@FXML Button tm;
	@FXML Button tr;
	@FXML Button ml;
	@FXML Button mm;
	@FXML Button mr;
	@FXML Button bl;
	@FXML Button bm;
	@FXML Button br;
	@FXML Text player1Label;
	@FXML Text player2Label;
	@FXML Text scoreLabel1;
	@FXML Text scoreLabel2;
	@FXML Text gameScoreLabel1;
	@FXML Text gameScoreLabel2;
	@FXML Text nameWarning;
	@FXML Text winnerName;
	@FXML TextField player1;
	@FXML TextField player2;
	@FXML Pane namePane;
	@FXML Pane winScreen;
	@FXML Pane block;
	
	@FXML public void initialize() {
		game = new Game();
		game.board.clearBoard();
		namePane.setVisible(true);
		winScreen.setVisible(false);
		block.setVisible(true);	
	}
	
	@FXML public void setPlayers() {
		try {
			
			try {
				game.player1 = (Player) game.IO.load("C:\\Programming\\" + player1.getText() + ".txt");
				
			}catch(Exception e) {
				System.out.println(e);
				Player.nameOk(player1.getText());
				game.player1 = new Player(player1.getText());	
			}
			
			try {
				game.player2 = (Player) game.IO.load("C:\\Programming\\" + player2.getText() + ".txt");
				
			}catch(Exception e) {
				System.out.println(e);
				Player.nameOk(player2.getText());
				game.player2 = new Player(player2.getText());
			}
			
			
			player1Label.setText(player1.getText());
			player2Label.setText(player2.getText());
			
			
			scoreLabel1.setText("" + game.player1.getScore());
			scoreLabel2.setText("" + game.player2.getScore());
			
			
			namePane.setVisible(false);
			nameWarning.setVisible(false);
			block.setVisible(false);
		
			
		}catch(Exception e){
			System.out.println(e);
			nameWarning.setText("" + e.getMessage());
			nameWarning.setVisible(true);
			
			}
		}
	
	private void isWin() {
		if (game.board.getIsWin()) {
			
			winnerName.setText("Congratulations " + game.board.getWinner().getName() + ", you won!");
			
			scoreLabel1.setText("" + game.player1.getScore());
			scoreLabel2.setText("" + game.player2.getScore());
			
			winScreen.setVisible(true);
			block.setVisible(true);
			
			try {
				game.IO.save(game.player1, "C:\\Programming\\" + game.player1.getName() + ".txt");
				game.IO.save(game.player2, "C:\\Programming\\" + game.player2.getName() + ".txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}else if (game.board.getIsDraw() == true) {
			winnerName.setText("It's a draw");
			winScreen.setVisible(true);
			block.setVisible(true);
		}
		
	}
	
	@FXML void restart() {
		game.board.clearBoard();
		winScreen.setVisible(false);
		block.setVisible(false);
		tl.setText("");
		tm.setText("");
		tr.setText("");
		ml.setText("");
		mm.setText("");
		mr.setText("");
		bl.setText("");
		bm.setText("");
		br.setText("");
	}
	
	
	
	@FXML public void tl() {
		if (tl.getText().isEmpty()) {
			game.board.setTile(0, 0);
			tl.setText(game.board.getTile(0, 0).toString());
			isWin();
		}
	}	
	
	@FXML public void tm() {
		if (tm.getText().isEmpty()) {
			game.board.setTile(0, 1);
			tm.setText(game.board.getTile(0, 1).toString());
			isWin();
		}
	}	
	
	@FXML public void tr() {
		if (tr.getText().isEmpty()) {
			game.board.setTile(0, 2);
			tr.setText(game.board.getTile(0, 2).toString());
			isWin();
		}
	}	
	
	@FXML public void ml() {
		if (ml.getText().isEmpty()) {
			game.board.setTile(1, 0);
			ml.setText(game.board.getTile(1, 0).toString());
			isWin();
		}
	}	
	
	@FXML public void mm() {
		if (mm.getText().isEmpty()) {
			game.board.setTile(1, 1);
			mm.setText(game.board.getTile(1, 1).toString());
			isWin();
		}
	}	
	
	@FXML public void mr() {
		if (mr.getText().isEmpty()) {
			game.board.setTile(1, 2);
			mr.setText(game.board.getTile(1, 2).toString());
			isWin();
		}
	}	
	
	@FXML public void bl() {
		if (bl.getText().isEmpty()) {
			game.board.setTile(2, 0);
			bl.setText(game.board.getTile(2, 0).toString());
			isWin();
		}
	}	
	
	@FXML public void bm() {
		if (bm.getText().isEmpty()) {
			game.board.setTile(2, 1);
			bm.setText(game.board.getTile(2, 1).toString());
			isWin();
		}
	}	
	
	@FXML public void br() {
		if (br.getText().isEmpty()) {
			game.board.setTile(2, 2);
			br.setText(game.board.getTile(2, 2).toString());
			isWin();
		}
	}	
}

