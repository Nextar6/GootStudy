package alo.java.exam;

public class AccountExample {

	public static void main(String[] args) {
		Account account = new Account();
		
		account.setBalance(10000);
		System.out.println("현재잔고 " + account.getBalance());
		
		account.setBalance(3000000);
		System.out.println("현재잔고 " + account.getBalance());
	}
		

}
