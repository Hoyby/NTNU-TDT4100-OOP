package inheritance.account;

public class DebitAccount extends AbstractAccount{

	@Override
	public void internalwithdraw(double amount) {
		
		if(this.balance - amount < 0) {
			throw new IllegalStateException("You dont have enough money");
		}else{
			this.balance -= amount;
		}
		
	}
	
	public DebitAccount() {
		
	}
}
