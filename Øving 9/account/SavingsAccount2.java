package inheritance.account;

public class SavingsAccount2 extends AbstractAccount{
	
	private int withdrawls;
	private int currentWithdrawls = 0;
	private double fee;

	@Override
	public void internalwithdraw(double amount) {
		System.out.println(this.balance + " - " + amount + " - " + withdrawls + " - " + currentWithdrawls + " - " + fee);
		if(this.balance - amount < 0){
			
			throw new IllegalStateException("You dont have enough money");
			
		}else if(currentWithdrawls == withdrawls){
			
			if(this.balance - (amount + fee) < 0){
				throw new IllegalStateException("You dont have enough money");
			}
			this.balance -= (amount + fee);
			
		}else{
			
			this.balance -= amount;
			currentWithdrawls ++;
		}
		
	}
	
	public SavingsAccount2(int withdrawls, double fee) {
		this.withdrawls = withdrawls;
		this.fee = fee;

	}

}
