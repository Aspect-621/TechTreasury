package TechTreasury;
import java.util.*;

public class registerUser extends userData {

	Scanner dataIn = new Scanner(System.in);
	private int accountFinal;
	String checkedName;
	String username;
	
	
	registerUser() {
		
		
		userData checkName = new userData();
		this.accountFinal = checkName.createAccountNumber();
		do{
			System.out.print("Enter your username: ");

			String usernameInput = dataIn.nextLine();
			this.username=usernameInput;
			this.checkedName = checkName.checkName(usernameInput);
		} while(checkedName ==null);
		
		
		System.out.print("Enter your password: ");
		String password = dataIn.nextLine();

		System.out.print("Enter your pin code: ");
		String pinCode = "null"; //dataIn.nextLine();

		System.out.print("Enter your first name: ");
		String fName = "null"; //dataIn.nextLine();

		System.out.print("Enter your middle name: ");
		String mName = "null"; //dataIn.nextLine();

		System.out.print("Enter your last name: ");
		String lName = "null"; //dataIn.nextLine();

		System.out.print("Enter your birth date: ");
		String birthDate = "null"; //dataIn.nextLine();

		System.out.print("Enter your gender: ");
		String gender = "null"; //dataIn.nextLine();

		System.out.print("Enter your address: ");
		String address = "null"; //dataIn.nextLine();

		System.out.print("Enter your father's name: ");
		String fatherName = dataIn.nextLine();

		System.out.print("Enter your mother's name: ");
		String motherName = dataIn.nextLine();

		System.out.print("Enter your contact number: ");
		String contactNumber = "null"; //dataIn.nextLine();

		double currentBal = 500;
		System.out.println("Default balance is:" + currentBal);

		userData newUser = new userData(checkedName, password, pinCode, fName, mName, lName, birthDate, gender, address, fatherName, motherName, contactNumber, accountFinal, currentBal);

		newUser.updateText();
		newUser.createUser();
		newUser.PrintAll();

	}

	public int accountNum123()
	{
		int accountNumber1 =  super.createAccountNumber();
		return accountNumber1;
	}




}
