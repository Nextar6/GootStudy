package alo.java.exam;

public class Account {
	public static final int MIN_BALACE = 0;
	public static final int MAX_BALACE = 10000000;

	private int balance;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		if(balance < Account.MIN_BALACE||
		balance > Account.MAX_BALACE) {
			return;
	}
		this.balance = balance;
}
}
