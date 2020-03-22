package com.capgemini.onlineWallet.test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.capgemini.onlineWallet.dao.UserDao;


public class UserDaoTest {
UserDao daoObject = new UserDao();

@Test
public void addMoneyTest() {

	assertEquals("Added: "+500+"\nnew balance: "+5500,daoObject.addMoney(500, 12345));
	 
	assertEquals("Could not find account",daoObject.addMoney(500, 127345));
}


@Test
public void debitMoneyTest() {
	
	assertEquals("Could not find account",daoObject.debitMoney(500, 1237845));
	
	assertEquals("not sufficient funds",daoObject.debitMoney(500000, 12345));
	
	assertEquals("debited: "+500+"\nremaining balance: "+5000,daoObject.debitMoney(500, 12345));
}


@Test
public void getAccountBalanceTest(){
	assertEquals("The balance is: "+5000,daoObject.getAccountBalance(12345));
	
	assertEquals("Could not find account",daoObject.getAccountBalance(123845));
}
}