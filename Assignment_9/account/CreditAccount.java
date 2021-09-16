package inheritance.account;

public class CreditAccount extends AbstractAccount {
	
	private double creditLine;

	@Override
	public void internalwithdraw(double amount) {
		
		if((this.balance + creditLine) - amount < 0) {
			throw new IllegalStateException("You dont have enough credit");
		}else{
			this.balance -= amount;
		}
	}
	
	public double getCreditLine() {
		return creditLine;
	}
	
	public void setCreditLine(double creditLine) {
		if (creditLine < 0) {
			throw new IllegalArgumentException("Credit cannot be negative");
		}else if(this.balance + creditLine < 0) {
			throw new IllegalStateException("New credit must cover existing debt");
		}
		this.creditLine = creditLine;
	}
	
	public CreditAccount(double creditLine) {
		this.creditLine = creditLine;
	}

}
