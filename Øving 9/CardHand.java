package inheritance;

public class CardHand extends CardContainerImpl implements CardContainer {
		
	private int maxCardCount;
	
	public CardHand(int n) {
		super();
		this.maxCardCount = n;
	}
	
	public void addCard(Card card) {
		if (this.deck.size() >= this.maxCardCount) {
			throw new IllegalStateException("You can only deal " + this.getMaxCardCount() + " cards");
		}else {
			this.deck.add(card);
		}
		
	}
	
	public Card play(int n) {
		return deck.remove(n);
	}
}