package com.capgemini.onlineWallet.util;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import com.capgemini.onlineWallet.dto.Account;



public class AccountRepository {

	private static List<Account> accountCollectionObject= new CopyOnWriteArrayList<Account>();// CopyOnWrite to use for each loop without error
	public AccountRepository(){
		accountCollectionObject.add(new Account(12345,5000));
		accountCollectionObject.add(new Account(12346,5000));
	}
	public static List<Account> getAccountCollectionObject() {
		return accountCollectionObject;
	}
	public static void setAccountCollectionObject(List<Account> accountCollectionObject) {
		AccountRepository.accountCollectionObject = accountCollectionObject;
	}
	
	  
}
