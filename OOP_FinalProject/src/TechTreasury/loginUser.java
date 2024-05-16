package TechTreasury;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class loginUser extends userData{


	private String loggedInUsername;
	private String enteredPassword;
	String filename = "NewAccount.txt";


	loginUser(String username, String password)
	{
		super( username,  password);
		this.loggedInUsername = username;
		this.enteredPassword = password;

	}

	public void loggedIn() {

		userData loggedInUserData = findUser(loggedInUsername);
		if (loggedInUserData != null) {
			String pass1 = loggedInUserData.getPassword();

			if (enteredPassword.equals(pass1))
			{

				System.out.println("Username: " + loggedInUserData.getUsername());
				System.out.println("Password: " + loggedInUserData.getPassword());
				System.out.println("Pin Code: " + loggedInUserData.getPinCode());
				System.out.println("First Name: " + loggedInUserData.getfName());
				System.out.println("Middle Name: " + loggedInUserData.getmName());
				System.out.println("Last Name: " + loggedInUserData.getlName());
				System.out.println("Birth Date: " + loggedInUserData.getBirthDate());
				System.out.println("Gender: " + loggedInUserData.getGender());
				System.out.println("Address: " + loggedInUserData.getAddress());
				System.out.println("Father's Name: " + loggedInUserData.getFatherName());
				System.out.println("Mother's Name: " + loggedInUserData.getMotherName());
				System.out.println("Contact Number: " + loggedInUserData.getContactNumber());
				System.out.println("Account Number" + loggedInUserData.loggedAccountNumber());
				System.out.println("Current Balance:" + loggedInUserData.getCurrentBal());
				transact transact = new transact();
				transact.transactChoice(loggedInUserData.loggedAccountNumber(),loggedInUserData.getCurrentBal());
				
			}
			else
			{
				System.out.println("Password is incorrect for: " + loggedInUsername);

			}

		}
		else 
		{
			System.out.print("User not found");
		}
	}

}



