package app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class GameController {
	
	Game game;
	
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
	@FXML Text nameWarning;
	@FXML Text winnerName;
	@FXML TextField player1;
	@FXML TextField player2;
	@FXML Pane namePane;
	@FXML Pane winScreen;
	@FXML Pane block;
	
	@FXML public void initialize() {
		game = new Game();
		namePane.setVisible(true);
		winScreen.setVisible(false);
		game.board.clearBoard();
		block.setVisible(true);
	}
	
	@FXML public void setPlayers() {
		if (player1.getText().matches("[A-Za-z]{2,}")) {
			game.player1.setName(player1.getText());;
			game.player2.setName(player2.getText());;
			namePane.setVisible(false);
			
			System.out.println(game.player1.getName());
			player1Label.setText(player1.getText());
			
			System.out.println(game.player2.getName());
			player2Label.setText(player2.getText());
			scoreLabel1.setText("" + game.player1.getScore());
			scoreLabel2.setText("" + game.player2.getScore());
			block.setVisible(false);
			System.out.println(game.board.getIsWin());
			
		}else {
			nameWarning.setVisible(true);
		}
	}
	
	private void isWin() {
		if (game.board.getIsWin() == true) {
			System.out.println(game.board.getIsWin());
			if (!(game.board.getMoveCount() % 2 == 0)) {
				winnerName.setText("Congratulations " + game.player1.getName() + ", you won!");
			}else {
				winnerName.setText("Congratulations " + game.player2.getName() + ", you won!");
			}
			scoreLabel1.setText("" + game.player1.getScore());
			scoreLabel2.setText("" + game.player2.getScore());
			winScreen.setVisible(true);
			block.setVisible(true);
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
	
	
	
	
	
//	@FXML void handleSetCar() {
//		String plate = carPlate.getText();
//		
//		Car tmpcar = this.getCar(plate);
//		if (tmpcar != null) {
//			car = tmpcar; // Den finnes
//		}
//		else {
//			System.out.println("Ny bil!");
//			car = new Car(carPlate.getText(),Integer.parseInt(carSeats.getText()));
//			cars.add(car);
//		}
//		carInfo.setText(car.toString());
//		ageInfo.setText(Integer.toString(car.totalAge()));
//	}
//
//	private Car getCar(String plate) {
//		for (Car carOrig : cars) {
//			System.out.println(carOrig.getPlate().toString()+" : "+plate);
//			if (carOrig.getPlate().toString().equals(plate)) {
//				System.out.println("Funnet: "+carOrig);
//				return carOrig;
//			}
//		}
//		return null;
//	}
//	
//
//	@FXML void handleRemoveHiker() {
//		car.removeHiker(this.getHiker(removeHiker.getText()));
//		car.setDriver(new Person(driverName.getText(), Integer.parseInt(driverAge.getText())));
//		carInfo.setText(car.toString());
//		ageInfo.setText(Integer.toString(car.totalAge()));
//	}
//
//	
//	private Person getHiker(String name) {
//		return car.getHiker(name);
//	}
//
//	@FXML void handleSetDriver() {
//		car.setDriver(new Person(driverName.getText(), Integer.parseInt(driverAge.getText())));
//		carInfo.setText(car.toString());
//		ageInfo.setText(Integer.toString(car.totalAge()));
//	}
//
//	@FXML void handleAddHiker() {
//		car.addHiker(new Person(hikerName.getText(), Integer.parseInt(hikerAge.getText())));
//		carInfo.setText(car.toString());
//		if (car.isFull())
//			addHiker.setDisable(true);
//		ageInfo.setText(Integer.toString(car.totalAge()));
//	}

