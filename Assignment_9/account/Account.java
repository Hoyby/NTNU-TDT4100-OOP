package inheritance.account;

public interface Account {
	
	void deposit(double amount);
	
	void withdraw(double amount);
	
	void internalwithdraw(double amount) throws IllegalStateException;
	
	double getBalance();
}
