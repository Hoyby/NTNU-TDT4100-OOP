package inheritance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardContainerImpl implements CardContainer {
	
	protected List<Card> deck = new ArrayList<Card>();
	private final int maxCardCount = 52;

	@Override
	public Iterator<Card> iterator() {
		return this.deck.iterator();
	}

	@Override
	public int getCardCount() {
		return deck.size();
	}
	
	public int getMaxCardCount() {
		return maxCardCount;
	}

	@Override
	public Card getCard(int n) {
		if (deck.size() < n) {
			throw new IllegalArgumentException("Card nr." + n + " does not exist.");
		}
		return deck.get(n);
	}
	
	public CardContainerImpl() {
		
	}

}
