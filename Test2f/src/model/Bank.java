package model;

public class Bank {
	
	private Account[] accounts = new Account[5];
	private int noa;
	
	public Bank() {
	}

	public Bank(Bank bank) {
		this.accounts = bank.accounts;
		this.noa = bank.noa;
	}

	public int getNumberOfAccounts() {
		return this.noa;
	}

	public Account[] getReferencesOfAccounts() {
		Account[] accounts = new Account[this.noa];
		
		for (int i = 0; i < this.noa; i++) {
			accounts[i] = this.accounts[i];
		}
		return accounts;
	}

	public Account[] getCopiesOfAccounts() {
		Account[] accounts = new Account[this.noa];
		
		for (int i = 0; i < this.noa; i++) {
			accounts[i] = new Account(this.accounts[i]);
		}
		return accounts;
	}

	public void addAccount(Account account) {
		this.accounts[this.noa] = account;
		this.noa++;
	}

	public void addAccounts(Account[] accounts) {
		Account[] new_accounts = new Account[this.noa + accounts.length];
		for (int i = 0; i < this.noa + accounts.length; i++) {
			if (i < this.noa) {
				new_accounts[i] = this.accounts[i];
			} else {
				new_accounts[i] = accounts[i - this.noa];
			}
		}
		
		this.noa += accounts.length;
		this.accounts = new_accounts;
		
	}
	
	public boolean equals (Object obj) {
		if(this == obj) { 
			return true; 
		}
		
		if (obj == null | this.getClass() != obj.getClass()) {
			return false;
		}

		Bank other = (Bank) obj;
		
		
		if (this.noa == other.noa) {
			boolean valid = true;
			for (int i = 0; valid && i < this.noa; i++) {
				valid = valid && this.accounts[i].equals(other.accounts[i]);
			}
			return valid;
		}
		return false;
	} 

}
