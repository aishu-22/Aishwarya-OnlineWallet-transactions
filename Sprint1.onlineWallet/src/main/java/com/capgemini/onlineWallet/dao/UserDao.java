package com.capgemini.onlineWallet.dao;
import java.util.List;

import com.capgemini.onlineWallet.dto.Account;
import com.capgemini.onlineWallet.util.AccountRepository;

public class UserDao {
	public UserDao(){
		new AccountRepository();
	}	
List<Account> newAccountCollectionObject=AccountRepository.getAccountCollectionObject();

	
	public String addMoney(int amount, int accountId) {
			for(Account i:  newAccountCollectionObject) {
			if(i.getAccountId()==accountId) {
				i.setAccountBalance(i.getAccountBalance()+amount);
				AccountRepository.setAccountCollectionObject(newAccountCollectionObject);
				return "Added: "+amount+"\nnew balance: "+i.getAccountBalance();
			}
		}
		return "Could not find account"; 
	}
	
	
	public String debitMoney(int amount, int accountId) {
		for(Account i: newAccountCollectionObject) {
			if(amount>i.getAccountBalance()) {
				return "not sufficient funds";
			}
			if(i.getAccountId()==accountId) {
				i.setAccountBalance(i.getAccountBalance()-amount);
				AccountRepository.setAccountCollectionObject(newAccountCollectionObject);
				return "debited: "+amount+"\nremaining balance: "+i.getAccountBalance();
				
			}
		}
		return "Could not find account";
	}
	
	
	public String getAccountBalance(int accountId ) {
		for(Account i: newAccountCollectionObject) {
			if(i.getAccountId()==accountId) {
				return "The balance is: "+i.getAccountBalance();
			}
		}
		return "Could not find account";
	}
}