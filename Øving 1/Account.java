package stateandbehavior;

public class Account {
	
	double balance;
	double interestRate;
	
	public void deposit(double deposit) {
		if (deposit > 0) {
			this.balance += deposit;
		}
	}
	
	public void addInterest() {
		this.balance *= (1 + (interestRate / 100));
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public Account() {
		super();
	}
	
	public String toString() {
		return "Balance: " + balance + "\n" + "Interest Rate: " + interestRate;
	}
	
	public static void main(String[] args) {
		Account a1 = new Account();
		a1.deposit(100);
		a1.setInterestRate(5);
		a1.addInterest();
		System.out.println(a1.toString());
	}
}
