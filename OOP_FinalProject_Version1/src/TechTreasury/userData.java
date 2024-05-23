package TechTreasury;
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class userData {
	private String filename = "NewAccount.txt";
	File filename1 = new File("NewAccount.txt");
	private String username;
	private String password;
	private String pinCode;
	private String fName;
	private String mName;
	private String lName;
	private String birthDate;
	private String gender;
	private String address;
	private String fatherName;
	private String motherName;
	private String contactNumber;
	private double currentBal;
	private int accountNumber = 2024100000;
	private int loggedAccountNumber;

	userData(String username, String password, String pinCode, String fName, String mName, String lName, String birthDate, String gender, String address, String fatherName, String motherName, String contactNumber, int accountNumber, double currentBal) {
		this.username = username;
		this.password = password; 
		this.pinCode = pinCode;
		this.fName = fName;
		this.mName = mName;
		this.lName = lName;
		this.birthDate = birthDate;
		this.gender = gender;
		this.address = address;	
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.contactNumber = contactNumber;
		this.currentBal = currentBal;
		this.loggedAccountNumber = accountNumber;
	}

	userData(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	userData ()
	{

	}



	public int createAccountNumber() {
		int accntNum = 0;
		if (filename1.exists()) {
			System.out.println("File exists. Reading account number...");

			try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
				String line;

				while ((line = reader.readLine()) != null) {
					String[] userData = line.split(":");

					if (userData[0].trim().equals("accntNum")) {

						accntNum = Integer.parseInt(userData[1].trim());

						System.out.println("Account number read from file: " + accntNum);

						reader.close();

						return accntNum; 
					}
				}
				reader.close();
			} catch (IOException e) {
				System.err.println("Error reading from file: " + e.getMessage());
				return 0;
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("File does not exist. Creating new account number...");
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
				accountNumber++; 
				writer.write("accntNum:" + accountNumber + "\n\n\n");
				writer.close();
				accntNum = accountNumber;
				System.out.println("New account number created: " + accntNum);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Data has been written to " + filename);
		return accntNum;
	}
	
	void updateText() {
		try {
			List<String> lines = Files.readAllLines(Paths.get(filename));
			for (int i = 0; i < lines.size(); i++) {
				String line = lines.get(i);
				if (line.startsWith("accntNum:")) {
					int newAccountNumber = Integer.parseInt(line.split(":")[1].trim());
					lines.set(i, "accntNum:" + (newAccountNumber + 1)); 
					break; 
				}
			}
			Files.write(Paths.get(filename), lines);
			System.out.println("Account number updated successfully.");
		} catch (IOException e) {
			System.err.println("Error updating account number: " + e.getMessage());
		}
	}
	
	
	

	public String checkName(String userName) {
		List<String> usernames = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains("username:")) {
					int startIndex = line.indexOf("username:") + "username:".length();
					String username = line.substring(startIndex).trim();
					usernames.add(username);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}


		for (int i = 0; i < usernames.size(); i++) {
			//for (int j = i + 1; j < usernames.size(); j++) {
			if (usernames.get(i).equals(userName)) {
				System.out.println("Usernames are the same. Enter another one");
				return null;
				//}
			}
		}

		System.out.println("Usernames are different.");
		return userName;
	}


	
	
	
	

	void createUser() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename,true));

			String userData = 
					"username:" + username + "\n" +
							"password:"+password+"\n" +
							"pinCode:"+pinCode+"\n" +
							"fName:"+fName+"\n" +
							"mName:"+mName+"\n" +
							"lName:"+lName+"\n" +
							"birthDate:"+birthDate+"\n" +
							"gender:"+gender+"\n" +
							"address:"+address+"\n" +
							"fatherName:"+fatherName+"\n" +
							"motherName:"+motherName+"\n" +
							"contactNumber:"+contactNumber+"\n" +
							"accountNumber:" + loggedAccountNumber +"\n" +
							"currentBal:"+currentBal+"\n" + "\n\n";
			writer.write(userData);
			writer.close();
			System.out.println("Data has been written to " + filename);

		} catch (IOException e) {
			System.err.println("Error writing to file: " + e.getMessage());
		}
	}


	void PrintAll()
	{
		System.out.println("userName:" + username + "\n" +
				"password:" + password + "\n" +
				"pinCode:" + pinCode + "\n" +
				"fName:" + fName + "\n" +
				"mName:" + mName + "\n" +
				"lName:" + lName + "\n" +
				"birthDate:" + birthDate + "\n" +
				"gender:" + gender + "\n" +
				"address:" + address + "\n" +
				"fatherName:" + fatherName + "\n" +
				"motherName:" + motherName + "\n" +
				"contactNumber:" + contactNumber + "\n" +
				"currentBal:" + currentBal + "\n" +
				"accountNumber:" + loggedAccountNumber + "\n\n");


	}

	
	public userData findUser(String usernameToFind) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;

			while ((line = reader.readLine()) != null) {
				String[] userData = line.split(":");
				if (userData[0].trim().equals("username") && userData[1].trim().equals(usernameToFind)) {
					String[] userAttributes = new String[14];
					userAttributes[0] = usernameToFind; 
					for (int i = 1; i < 14; i++) {
						userAttributes[i] = reader.readLine().split(":")[1].trim();
					}
					reader.close();
					return new userData(userAttributes[0], userAttributes[1], userAttributes[2], userAttributes[3], userAttributes[4], 
							userAttributes[5], userAttributes[6], userAttributes[7], userAttributes[8], userAttributes[9], userAttributes[10], 
							userAttributes[11],Integer.parseInt(userAttributes[12]), Double.parseDouble(userAttributes[13]));

				}
			}

			reader.close();
			return null;
		} catch (IOException e) {
			System.err.println("Error reading from file: " + e.getMessage());
			return null;
		}
	}
	
	/*
	 userData findUser(String usernameToFind) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(":");
                if (userData.length < 2) {
                    continue; // Skip malformed lines
                }
                if (userData[0].trim().equals("username") && userData[1].trim().equals(usernameToFind)) {
                    String[] userAttributes = new String[14];
                    userAttributes[0] = usernameToFind; // Assuming the username is the first attribute
                    for (int i = 1; i < 14; i++) {
                        line = reader.readLine();
                        if (line == null) {
                            throw new IOException("Unexpected end of file while reading user attributes.");
                        }
                        String[] attributeData = line.split(":");
                        if (attributeData.length < 2) {
                            throw new IOException("Malformed line for attribute " + i + ": " + line);
                        }
                        userAttributes[i] = attributeData[1].trim();
                    }
					return new userData(userAttributes[0], userAttributes[1], userAttributes[2], userAttributes[3], userAttributes[4], userAttributes[5], userAttributes[6], userAttributes[7], userAttributes[8], userAttributes[9], userAttributes[10], userAttributes[11], Double.parseDouble(userAttributes[12]) ,Integer.parseInt(userAttributes[13]));

                    
                }
            }
            return null;
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            return null;
        }
    }*/

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getPinCode() {
		return pinCode;
	}

	public String getfName() {
		return fName;
	}

	public String getmName() {
		return mName;
	}

	public String getlName() {
		return lName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public String getGender() {
		return gender;
	}

	public String getAddress() {
		return address;
	}

	public String getFatherName() {
		return fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public double getCurrentBal() {
		return currentBal;
	}

	public int accountNumber()
	{
		return accountNumber;
	}
	
	public int loggedAccountNumber()
	{
		return loggedAccountNumber;
	}
	



}
