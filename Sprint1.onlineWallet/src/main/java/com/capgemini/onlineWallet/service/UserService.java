package com.capgemini.onlineWallet.service;
import com.capgemini.onlineWallet.dao.UserDao;
import com.capgemini.onlineWallet.exceptions.InvalidInputDetails;

public class UserService {

	UserDao daoObject=new UserDao();
	
	//Add money
	public String addMoney(int amount, int accountId) throws InvalidInputDetails {
		if(amount==0) { 
			throw new InvalidInputDetails("Amount 0 cannot be added");
		}
		if(accountId==0) {
			throw new InvalidInputDetails("Account Id cannot be zero");
		} 
		return daoObject.addMoney(amount, accountId);
	}
	
	
	//debit money
	public String debitMoney(int amount, int accountId) throws InvalidInputDetails {
		if(amount==0) {
			throw new InvalidInputDetails("Amount 0 cannot be debited");
		}
		if(accountId==0) {
			throw new InvalidInputDetails("Account Id cannot be zero");
		}
		return daoObject.debitMoney(amount, accountId);	
	}
	//show balanace
	public String getAccountBalance(int accountId) throws InvalidInputDetails{
		if(accountId==0) {
			throw new InvalidInputDetails("Account Id cannot be zero");
		}
		return daoObject.getAccountBalance(accountId);
	}
}