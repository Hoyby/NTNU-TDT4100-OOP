package inheritance;

public interface CardContainer extends Iterable<Card>{

	int getCardCount();
	
	Card getCard(int n);
}
