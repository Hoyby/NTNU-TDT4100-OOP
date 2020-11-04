package inheritance.account;

public abstract class AbstractAccount implements Account {
	
	protected int balance;

	@Override
	public void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Illegal ammount");
		}
		this.balance += amount;
	}

	@Override
	public void withdraw(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Illegal ammount");
		}
		internalwithdraw(amount);
	}

	@Override
	public abstract void internalwithdraw(double amount) throws IllegalStateException;

	@Override
	public double getBalance() {
		return this.balance;
	}
	
	public AbstractAccount() {
		this.balance = 0;
	}

}
