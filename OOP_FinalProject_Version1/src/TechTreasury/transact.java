package TechTreasury;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class transact {
	Scanner dataIn = new Scanner(System.in);
	private String filename = "NewAccount.txt";


	double transactChoice(int accountNumber, double balance) {
		System.out.println("[1] Check Balance \n[2] Withdraw \n[3] Send Money \n[4] Deposit Money");
		System.out.print("What would youu like to do:");

		int choice = dataIn.nextInt(); 
		dataIn.nextLine(); 

		for (int y =0; y<1; y++) {


			int x =0;

			switch (choice)
			{

			case 1:
				System.out.println("Checking Balance...");
				System.out.println("Current Balance:" + balance);
				return balance;
			case 2:
				System.out.println("Current Balance:" + balance);
				do {
					System.out.print("Enter Amount to Withdraw:");
					double withrawAmount = dataIn.nextInt(); 
					dataIn.nextLine(); 
					double checkAmount = withrawAmount % 100;

					if (checkAmount==0)
					{
						//balance -=withrawAmount;
						updateBalance(accountNumber, withrawAmount);
						x++;
					}
					else
					{
						System.out.println("Please Enter in Multiples of 100!");
					}
				}while(x<1);

				//return balance;
break;
			case 3:
				System.out.println("Current Balance:" + balance);
				do {
					System.out.print("Enter Amount to Send:");
					double sendAmount = dataIn.nextInt(); 
					dataIn.nextLine(); 
					System.out.print("Enter Account Number to Send:");
					int sendAccount = dataIn.nextInt(); 
					dataIn.nextLine(); 
					//balance -=sendAmount;
					updateBalance(accountNumber, sendAmount);
					updateBalance(sendAccount, (sendAmount*(-1)));

					x++;



				}while(x<1);

				//return balance;
				break;
			case 4:
				System.out.println("Current Balance:" + balance);
				System.out.print("Enter Amount to Send:");
				double depositAmount = dataIn.nextInt(); 
				dataIn.nextLine(); 
				balance +=depositAmount;
				break;

				//return balance;
			default:
				System.out.println("Please Select 1 or 2");
				break;
			}
		}	
		return balance;
	}

	public void updateBalance(int accountNumber, double amountValue) {
	    File file = new File(filename);

	    if (!file.exists()) {
	        System.out.println("File does not exist.");
	        return;
	    }

	    List<String> updatedLines = new ArrayList<>();
	    boolean accountFound = false;

	    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	        String currentLine;

	       
	        while ((currentLine = reader.readLine()) != null) {
	            if (currentLine.startsWith("accountNumber:" + accountNumber)) {
	                accountFound = true;
	                String nextLine = reader.readLine(); 
	                if (nextLine != null && nextLine.startsWith("currentBal:")) { 
	                    double currentBalance = Double.parseDouble(nextLine.split(":")[1]);
	                    double newBalance = currentBalance - amountValue;
	                    updatedLines.add("accountNumber:" + accountNumber);
	                    updatedLines.add("currentBal:" + newBalance);
	                } else {
	                    System.out.println("Invalid format for balance line following account number: " + accountNumber);
	                    return; 
	                }
	            } else {
	                updatedLines.add(currentLine);
	            }
	        }

	        if (!accountFound) {
	            System.out.println("Account not found." + accountNumber);
	            return;
	        }

	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

	            for (String line : updatedLines) {
	                writer.write(line);
	                writer.newLine();
	            }
	            System.out.println("Balance updated successfully.");
	        } catch (IOException e) {
	            System.err.println("Error writing to file: " + e.getMessage());
	        }
	    } catch (IOException e) {
	        System.err.println("Error reading from file: " + e.getMessage());
	    }
	}
}
