package model;

public class Account {
	
	private String name;
	private int balance;
	
	private int vip_balance;
	
	private String status;

	public Account(String name, int balance) {
		this.name = name;
		this.balance = balance;
		
		this.status = "A regular account owned by " + name + " with balance $" + balance;
	}
	
	public Account(Account account) {
		this (new String(account.name), account.balance);
		this.vip_balance = account.vip_balance;
		this.status = new String(account.status);
	}

	public String toString() {
		return this.status;
	}

	public void switchToVIP(int balance) throws InsufficientBalanceException, InvalidStatusToSwitchException {
		if (this.vip_balance == 0) {
			if (this.balance >= balance) {
				this.balance -= balance;
				this.vip_balance = balance;
				this.status = "A VIP account owned by " + this.name + " with balance $" + this.balance + " ($" + balance + " deposited for maintaining the VIP stauts)";
			} else {
				throw new InsufficientBalanceException();
			}
		} else {
			throw new InvalidStatusToSwitchException();
		}
	}

	public void switchToRegular() throws InvalidStatusToSwitchException {
		if (this.vip_balance > 0) {
			this.balance += this.vip_balance;
			this.vip_balance = 0;
			this.status = "A regular account owned by " + name + " with balance $" + balance;
		} else {
			throw new InvalidStatusToSwitchException();
		}
	}
	
	public boolean equals (Object obj) {
		if(this == obj) { 
			return true; 
		}
		
		if (obj == null | this.getClass() != obj.getClass()) {
			return false;
		}

		Account other = (Account) obj;
		if (this.vip_balance > 0) {
			if (other.vip_balance > 0) {
				return this.name.equals(other.name) && this.balance == other.balance;
			}
		} else {
			if (other.vip_balance == 0) {
				return this.name.equals(other.name) && this.balance == other.balance;
			}
		}
		return false;
	} 

}
