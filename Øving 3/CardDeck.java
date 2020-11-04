package debugging;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CardDeck {
	
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
	
	public int getCardCount() {
		return cardDeck.size();
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
	
	public Card getCard(int n) {
		if (cardDeck.size() < n) {
			throw new IllegalArgumentException("Card nr." + n + " does not exist.");
		}
		return cardDeck.get(n);
	}
}
