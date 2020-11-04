package interfaces;

import java.util.ArrayList;
import java.util.List;

public class CardDeck implements CardContainer  {
	
	private ArrayList<Card> cardDeck = new ArrayList<Card>();
		
	
	public CardDeck(int n) {
			for (int i = 1; i < n + 1; i++) {
				cardDeck.add(new Card('S', i));
			}
			for (int i = 1; i < n + 1; i++) {
				cardDeck.add(new Card('H', i));
			}
			for (int i = 1; i < n + 1; i++) {
				cardDeck.add(new Card('D', i));
			}
			for (int i = 1; i < n + 1; i++) {
				cardDeck.add(new Card('C', i));
			}
	}
	
	
	public void shufflePerfectly() {
		List<Card> firstHalf = new ArrayList(cardDeck.subList(0, cardDeck.size()/2));
		List<Card> secondHalf = new ArrayList(cardDeck.subList(cardDeck.size()/2, cardDeck.size()));
		int x = 0;
		for (int i = 0; i < getCardCount(); i++) {
			this.cardDeck.set(i, firstHalf.get(x));
			i++;
			this.cardDeck.set(i, secondHalf.get(x));
			x++;
		}
		
	}
	
	
	public void deal(CardHand cardhand, int n) {
		int count = getCardCount();
		if (n > 0 && n < getCardCount()) {
			
			
			for (int i = 0; i < n; i++) {
				cardhand.addCard(this.getCard((count - 1) - i));
				this.cardDeck.remove((count - 1) - i);
			}
			
			
//			int to = getCardCount() - 1 - n;
//			for (int i = getCardCount() - 1; i < to; i--) {
//				System.out.println(getCard(i) + " dealt to");
//				cardhand.addCard(this.getCard(i));
//				this.cardDeck.remove(i);
//			}
		}
	}
	
	
	public Card getCard(int n) {
		if (cardDeck.size() < n) {
			throw new IllegalArgumentException("Card nr." + n + " does not exist.");
		}
		return cardDeck.get(n);
	}
	
	
	public int getCardCount() {
		return cardDeck.size();
	}
	
	public static void main(String[] args) {
		CardDeck c1 = new CardDeck(13);
		CardHand cardhand = new CardHand();
		System.out.println("--------");
		for (int i = 1; i < c1.getCardCount(); i++) {
			System.out.println(c1.getCard(i-1).compareTo(c1.getCard(i)));
		}
		c1.shufflePerfectly();
		for (int i = 0; i < c1.getCardCount(); i++) {
			System.out.println(c1.getCard(i));
		}
		System.out.println("--------");
		for (int i = 1; i < c1.getCardCount(); i++) {
			System.out.println(c1.getCard(i-1).compareTo(c1.getCard(i)));
		}
		for (int i = 0; i < c1.getCardCount(); i++) {
			System.out.println(c1.getCard(i));
		}
		
		
	}
}
