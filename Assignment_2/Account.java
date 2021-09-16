package encapsulation;

import encapsulation.Account;

public class Account {
	
	private double balance;
	private double interestRate;
	
	public void deposit(double deposit) {
		if (deposit < 0) {
			throw new IllegalArgumentException("Cannot create account using negative number");
		}
		this.balance += deposit;
	}
	
	public void withdraw(double withdraw) {
		if (withdraw < 0 || withdraw > balance) {
			throw new IllegalArgumentException("Cannot create account using negative number");
		}
		this.balance -= withdraw;
	}
	
	public void addInterest() {
		this.balance *= (1 + (interestRate / 100));
	}

	public void setInterestRate(double interestRate) {
		if (interestRate < 0){
			throw new IllegalArgumentException("Cannot create account using negative number");
		}
		this.interestRate = interestRate;	
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public Account(double balance, double intrestRate) {
		super();
		if (balance < 0 || intrestRate < 0){
			throw new IllegalArgumentException("Cannot create account using negative number");
		}
		this.balance = balance;
		this.interestRate = intrestRate;
		
		
	}
	
	public String toString() {
		return "Balance: " + balance + "\n" + "Interest Rate: " + interestRate;
	}
	
	public static void main(String[] args) {
		Account a1 = new Account(0, 0);
		a1.deposit(100);
		a1.setInterestRate(5);
		a1.addInterest();
		System.out.println(a1.toString());
	}
}
