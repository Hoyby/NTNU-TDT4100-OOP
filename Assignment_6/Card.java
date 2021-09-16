package interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Card implements Comparable<Card>{
	
	private char suit;
	private int face;
	private List<Character> suits = new ArrayList<Character>(Arrays.asList('S', 'H', 'D', 'C'));
	
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

	@Override
	public int compareTo(Card c) {
		
		if (suits.indexOf(suit) > suits.indexOf(c.suit)) {
			return 1;
		}
		else if (suits.indexOf(suit) < suits.indexOf(c.suit)) {
			return -1;
		}
		else {
			return face > c.face ? 1 : -1;
		}
	}
	
	public static void main(String[] args) {
		Card c1 = new Card('H', 2);
		Card c2 = new Card('D', 5);
		Card c3 = new Card('D', 3);
		Card c4 = new Card('C', 3);
		Card c5 = new Card('C', 4);
		Card c6 = new Card('H', 1);
		Card c7 = new Card('S', 7);
		Card c8 = new Card('H', 13);
		Card c9 = new Card('H', 12);
		List liste = new ArrayList<>(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9));
		System.out.println(liste);
		Collections.sort(liste);
		System.out.println(liste);
		
		System.out.println("--------");
		CardComparator cc = new CardComparator(true, 'C');
		Collections.sort(liste, cc);
		System.out.println(liste);
	}
}
