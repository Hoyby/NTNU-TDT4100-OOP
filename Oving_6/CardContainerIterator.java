package interfaces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardContainerIterator implements Iterator<Card>{
	
	private int position = -1;
	private List<Card> list = new ArrayList<Card>();
	
	
	public CardContainerIterator(CardContainer cardcontainer) {
		for (int i = 0; i < cardcontainer.getCardCount(); i++) {
			list.add(cardcontainer.getCard(i));
		}
	}

	public static void main(String[] args) {
		CardContainerIterator cci = new CardContainerIterator(new CardDeck(13));
		while (cci.hasNext()) {
			System.out.println(cci.next());
		}
	}

	@Override
	public boolean hasNext() {
		return position + 1 < list.size() ? true : false;
	}

	@Override
	public Card next() {
		position ++;
		return position < list.size() ? list.get(position) : null;
	}
	
}
