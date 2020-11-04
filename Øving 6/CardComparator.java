package interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class CardComparator implements Comparator<Card> {
	
	private List<Character> suits = new ArrayList<Character>(Arrays.asList('S', 'H', 'D', 'C'));
	Boolean aceHigh;
	char trumf;

	@Override
	public int compare(Card c1, Card c2) {
		if (suits.contains(trumf)) {
			suits.remove(suits.indexOf(trumf));
			suits.add(0, trumf);
		}
		
		
		if (suits.indexOf(c1.getSuit()) > suits.indexOf(c2.getSuit())) {
			return -1;
		}
		else if (suits.indexOf(c1.getSuit()) < suits.indexOf(c2.getSuit())) {
			return 1;
		}
		else {
			if (aceHigh && (c1.getFace() == 1 || c2.getFace() == 1)) {
				return c1.getFace() > c2.getFace() ? -1 : 1;
			}
			return c1.getFace() > c2.getFace() ? 1 : -1;
		}
	}
	
	public CardComparator(Boolean aceHigh, char trumf) {
		this.aceHigh = aceHigh;
		this.trumf = trumf;
		
		
	}
	
}
