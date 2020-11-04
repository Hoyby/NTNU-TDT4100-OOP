package debugging;

public class Card {
	
	private char suit;
	private int face;
	
	public char getSuit() {
		return suit;
	}
	
	public int getFace() {
		return face;
	}
	
	
	public Card(char suit, int face) { 
		super();
		if (face > 13 || face < 1) {
			throw new IllegalArgumentException("Face " + face + " not valid");
		}else if (suit != 'S' && suit != 'H' && suit != 'D' && suit != 'C') {
			throw new IllegalArgumentException("Suit " + suit + " not valid");
		}
		this.face = face;
		this.suit = suit;
	}


	public String toString() {
		return suit + "" + face;
	}
	
}
