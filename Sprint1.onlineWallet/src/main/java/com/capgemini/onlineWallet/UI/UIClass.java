package com.capgemini.onlineWallet.UI;
import java.util.Scanner;

import com.capgemini.onlineWallet.exceptions.InvalidInputDetails;
import com.capgemini.onlineWallet.service.UserService;

public class UIClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserService serviceObject=new UserService();
		Scanner scanObject=new Scanner(System.in); 

		int userChoice=1;
		int inputAmount;
		int inputAccountId;
		
		while(userChoice!=0) {
			System.out.println("Enter your choice:");
			System.out.println("1.Add Money\n2.Debit money\n3.Display account details\n0 for exit");
			userChoice=scanObject.nextInt(); 
			
			switch(userChoice) {
			case 1:
				System.out.println("Enter amount:");
				inputAmount=scanObject.nextInt();
				System.out.println("Enter account Id:");
				inputAccountId=scanObject.nextInt();
				
				try {
					System.out.println(serviceObject.addMoney(inputAmount, inputAccountId));
				} catch (InvalidInputDetails e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 2:
				System.out.println("Enter amount:");
				inputAmount=scanObject.nextInt();
				System.out.println("Enter account Id:");
				inputAccountId=scanObject.nextInt();
				
				try {
					System.out.println(serviceObject.debitMoney(inputAmount, inputAccountId));
				} catch (InvalidInputDetails e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 3:
	
				System.out.println("Enter account Id:");
				inputAccountId=scanObject.nextInt();

				try {
					System.out.println(serviceObject.getAccountBalance(inputAccountId));
					}
				
				
				catch (InvalidInputDetails e) {
					System.out.println(e.getMessage());
				}
				break;
			}
		}
		
		scanObject.close();

	}

}		