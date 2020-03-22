package com.capgemini.onlineWallet.test;

import com.capgemini.onlineWallet.exceptions.InvalidInputDetails;
import com.capgemini.onlineWallet.service.UserService;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;



public class UserServiceTest {
UserService serviceObject=new UserService();


int account=12345; 
int amount=500;

public void addMoneyTest() throws InvalidInputDetails {
	Throwable exception = assertThrows(
			Exception.class,()->{
				serviceObject.addMoney(0, account);
			});
	assertEquals("Amount 0 cannot be added",exception.getMessage());
	
	
	exception = assertThrows(
			Exception.class,()->{
				serviceObject.addMoney(amount, 0);
			});
	assertEquals("Account Id cannot be zero",exception.getMessage());
	
	assertEquals("Added: "+500+"\nnew balance: "+5500,serviceObject.addMoney(amount, account));
	
}
 

@Test
public void debitMoneyTest() throws InvalidInputDetails {
	Throwable exception = assertThrows(
			Exception.class,()->{
				serviceObject.debitMoney(0, account);
			});
	assertEquals("Amount 0 cannot be debited",exception.getMessage());
	
	
	exception = assertThrows(
			Exception.class,()->{
				serviceObject.debitMoney(amount, 0);
			});
	assertEquals("Account Id cannot be zero",exception.getMessage());
	
	assertEquals("debited: "+500+"\nremaining balance: "+4500,serviceObject.debitMoney(500, 12345));
}



@Test
public void getAccountBalanceTest() throws InvalidInputDetails{
	Throwable exception=assertThrows(
			Exception.class,()->{
				serviceObject.getAccountBalance(0);
			});
	assertEquals("Account Id cannot be zero",exception.getMessage());
	
	assertEquals("Could not find account",serviceObject.getAccountBalance(123458));
	
	assertEquals("The balance is: "+4500,serviceObject.getAccountBalance(12345));
	
	
}


}