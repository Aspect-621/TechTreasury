package TechTreasury;
import java.util.*;

public class homepage {
	Scanner dataIn = new Scanner(System.in);

	public void home(){
		
		for (int x = 0; x<1; x--) {
		System.out.print("Would you like to [1]Login or [2]Register:");
		int choice = dataIn.nextInt(); 
        dataIn.nextLine(); // Consume newline

		switch (choice)
		{
		case 1:
			System.out.println("Log In Page");

			System.out.println("Please Enter your Username:");
			String username = dataIn.nextLine();

			System.out.println("Please Enter your password:");
			String password = dataIn.nextLine();

			loginUser logUser = new loginUser(username,password);
			logUser.loggedIn();
			
		
			
			break;
		case 2:
			registerUser newUser =  new registerUser();
			newUser.accountNum123();
			
			break;
		default:
			System.out.println("Please Select 1 or 2");

			break;
		}
		
		
		
	}
	
	}
}
