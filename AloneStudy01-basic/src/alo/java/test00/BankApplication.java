package alo.java.test00;

import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("=============================================");
			System.out.println("1. 계좌생성 |2. 계좌목록 |3. 예금 |4. 출금 |5. 종료");
			System.out.println("=============================================");
			System.out.println("선택>");

			int selectNo = sc.nextInt();

			if (selectNo == 1) {
				creatAccount();
			} else if (selectNo == 2) {
				accountList();
			} else if (selectNo == 3) {
				deposit();
			} else if (selectNo == 4) {
				withdraw();
			} else if (selectNo == 5) {
				run = false;
			}
		}
		System.out.println("포르그램 종료");

	} // end main()

	private static void creatAccount() {
		System.out.println("---------");
		System.out.println(" 계좌생성");
		System.out.println("---------");

		System.out.println("계좌번호 입력 :");
		String ano = sc.next();
		
		System.out.println("계좌주 :");
		
		String owner = sc.next();
		System.out.println("초기입금액 :");
		int balance = sc.nextInt();
		Account newAccount = new Account(ano, owner, balance);
		
		for(int i = 0; i < accountArray.length; i++) {
			if(accountArray[i] == null) {
				accountArray[i] = newAccount;
				System.out.println("결과 : 계좌가 생성되었습니다.");
				break;
			}
		}
	}

	private static void accountList() {
		System.out.println("---------");
		System.out.println(" 계좌목록");
		System.out.println("---------");
		for(int i = 0; i < accountArray.length; i++) {
			Account account = accountArray[i];
			if(account != null) {
			System.out.println("계좌번호");
			System.out.println(account.getAno());
			System.out.println("계좌주");
			System.out.println(account.getOwner());
			System.out.println("금액");
			System.out.println(account.getBalance());
			System.out.println();}
			}
		

	}

	private static void deposit() {
		System.out.println("======");
		System.out.println(" 예금");
		System.out.println("======");
		System.out.println("계좌번호");
		String ano = sc.next();
		System.out.println("예금액");
		int money = sc.nextInt();
		
		Account account = findAccount(ano);
		if(account == null) {
			System.out.println("계좌가 없습니다");
			return;
			
		}
		account.setBalance(account.getBalance()+ money);
		System.out.println("결과 : 입금이 성공 되었습니다.");
	}
	private static Account findAccount(String ano) {
		Account account = null;
		for(int i = 0; i < accountArray.length; i++) {
			if(accountArray[i] != null) {
				String dbAno = accountArray[i].getAno();
				if(dbAno.equals(ano)) {
					account = accountArray[i];
					break;
				}
			}
			
		}
		return account;
	}

	private static void withdraw() {
		System.out.println("======");
		System.out.println(" 출금");
		System.out.println("======");
		System.out.println("계좌번호");
		String ano = sc.next();
		System.out.println("출금액");
		int money = sc.nextInt();
		
		Account account = findAccount(ano);
		if(account == null) {
			System.out.println("계좌가 없습니다");
			return;
			
		}
		account.setBalance(account.getBalance()- money);
		System.out.println("결과 : 출금이 성공 되었습니다.");
	
	
			
	
	}

} // end BankApplication
