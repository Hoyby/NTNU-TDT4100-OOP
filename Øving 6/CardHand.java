package interfaces;

import java.util.ArrayList;

public class CardHand implements CardContainer {
		
	private ArrayList<Card> cardHand = new ArrayList<Card>();
	
	public CardHand() {
		super();
	}
	
	public Card getCard(int n) {
		if (cardHand.size() < n) {
			throw new IllegalArgumentException("Card nr." + n + " does not exist.");
		}
		return cardHand.get(n);
	}
	
	public int getCardCount() {
		return cardHand.size();
	}
	
	public void addCard(Card card) {
		this.cardHand.add(card);
	}
	
	public Card play(int n) {
		Card card = getCard(n);
		cardHand.remove(n);
		return card;
	}

}