package inheritance;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CardDeck extends CardContainerImpl implements CardContainer {
	
	public CardDeck(int n) {
		super();
		if (n > this.getMaxCardCount()/4) {
			throw new IllegalArgumentException("A deck of card contains no more than a total of 52 cards");
		}else {
			for (int i = 1; i < n + 1; i++) {
				deck.add(new Card('S', i));
			}
			for (int i = 1; i < n + 1; i++) {
				deck.add(new Card('H', i));
			}
			for (int i = 1; i < n + 1; i++) {
				deck.add(new Card('D', i));
			}
			for (int i = 1; i < n + 1; i++) {
				deck.add(new Card('C', i));
			}
		}
	}
	
	public void shufflePerfectly() {
		List<Card> firstHalf = new ArrayList<Card>(deck.subList(0, deck.size()/2));
		List<Card> secondHalf = new ArrayList<Card>(deck.subList(deck.size()/2, deck.size()));
		int x = 0;
		for (int i = 0; i < getCardCount(); i++) {
			this.deck.set(i, firstHalf.get(x));
			i++;
			this.deck.set(i, secondHalf.get(x));
			x++;
		}
	}
	
	public void deal(CardHand cardhand, int n) {
		int count = getCardCount();
		if (n > 0 && n <= getCardCount()) {
			
			for (int i = 0; i < n; i++) {
				System.out.println(getCard((count - 1) - i) + " dealt to");
				cardhand.addCard(this.deck.remove((count - 1) - i));
			}
		}
	}
	
	public Boolean hasCard(Predicate<Card> p) {
		for (Card card : deck) {
			if (p.test(card)) {
				return true;
			}
		}
		return false;
	}
	
	public int getCardCount(Predicate<Card> p) {
		return 0;
	}
	
	public List<Card> getCards(Predicate<Card> p) {
		return deck;
	}
	
	public static void main(String[] args) {
		CardDeck c1 = new CardDeck(13);
		CardHand h1 = new CardHand(52);
		c1.deal(h1, 52);
		
		System.out.println(c1.getCardCount());
		System.out.println(h1.getCardCount());
		
//		c2.deal(h1, 1);
	}
}
	
	
	
	
	
	
	
	
