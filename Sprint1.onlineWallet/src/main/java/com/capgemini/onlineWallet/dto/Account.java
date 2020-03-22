package com.capgemini.onlineWallet.dto;

public class Account {
private int accountId;
private int accountBalance;

public Account(){}


public Account(int accountId, int accountBalance) {
	
	this.accountId = accountId;
	this.accountBalance = accountBalance;
}


public int getAccountId() {
	return accountId;
}

public void setAccountId(int accountId) {
	this.accountId = accountId;
}

public int getAccountBalance() {
	return accountBalance;
} 

public void setAccountBalance(int accountBalance) {
	this.accountBalance = accountBalance;
}



}