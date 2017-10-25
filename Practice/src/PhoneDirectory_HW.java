
import java.util.Scanner;

public class PhoneDirectory_HW {
	// Class variables
	static PhoneRecord[] records = new PhoneRecord[50];
	static int recordCount = 0;
	static Scanner sc ;


	public static void main(String[] args) {


		// Display list of commands
		System.out.println("Phone directory commands:\n"
				+ "  a - Add a new phone number\n"
				+ "  d - Display All\n"
				+ "  da -Display all with same Last Name\n"
				+ "  f - Find a phone number\n"
				+ "  r - Remove a phone number\n"
				+ "  rc -Remove all records with same zip code\n"
				+ "  q - Quit\n");

		// Read and execute commands
		while (true) {
			sc= new Scanner(System.in);

			// Prompt user to enter a command
			System.out.print("Enter command (a, d, da, f, r, rc or q): ");
			String command = sc.nextLine();

			// Determine whether command is "a", "f", "q", or
			// illegal; execute command if legal.
			if (command.equalsIgnoreCase("a")) {

				// Command is "a". Call addNumber to add a new
				// name and number to the database
				addNumber();
			} else if (command.equalsIgnoreCase("f")) {

				// Command is "f". Call findNumber to find phone
				// numbers that match the user's criteria.
				findNumber();
			} else if (command.equalsIgnoreCase("d")) {

				// Command is "d". Call displayRecords to display all phone
				// numbers
				displayRecords();
			}else if (command.equalsIgnoreCase("da")) {

				// Command is "d". Call displayRecords to display all phone
				// numbers
				displayRecordsWithSameLastName();
			}
			else if (command.equalsIgnoreCase("r")) {

				// Command is "r". Call removeNumber to remove phone
				// numbers that match the user's criteria.
				removeNumber();
			}else if (command.equalsIgnoreCase("rc")) {

				// Command is "r". Call removeNumber to remove phone
				// numbers that match the user's criteria.
				removeNumberWithSameZipCode();
			}
			else if (command.equalsIgnoreCase("q")) {

				// Command is "r". Call removeNumber to remove phone
				// numbers that match the user's criteria.
				break;
			}
			else {

				// Command is illegal. Display error message.
				System.out.println("Command was not recognized; "
						+ "please enter only a, d, da, f, r, rc or q.");
			}

			System.out.println();
		}
	}
	private static void addNumber() {
//this method adds a phone record, ie. first name, lastname,
//phone number and zipcode		

		System.out.print("Enter first name: ");
		String firstName = sc.next();
		
		System.out.print("Enter last name: ");
		String lastName = sc.next();
		
		System.out.print("Enter phone number: ");
		String phoneNumber = sc.nextLine();
		
		System.out.print("Enter zip code: ");
		int zipCode = sc.nextInt();
	}
	
	private static void removeNumber() {
		//this code removes a phone no. 
				System.out.println("Enter phone no:");
				String pFind = sc.next();
				int index = 0;
				boolean found = true;
				for(int i=0;i<recordCount;i++){
					if(records[i].getNumber().equals(pFind))
					{
						index =i;
						for(int j=index;j<recordCount;j++){
							records[j]=records[j+1];
						}
						System.out.println("Record with phone no: "+ pFind+" deleted.");
						records[recordCount-1]=null;
						recordCount--;
						found = true;
					}
					else
					{
						found = false;
					}
					
				}
				if(!found)
					System.out.println("The phone no. does not exist.");
				
					
	}

	private static void displayRecords() {
		for (int i = 0; i < recordCount; i++) {
			System.out.println(i + 1 + ". " + records[i].getName() + " "
					+ records[i].getNumber()+" "+records[i].getZipCode());
		}
	}
		
		
		
	private static void removeNumberWithSameZipCode() {
		// your code here
		
		System.out.print("Enter zip code: ");
		String zipFind = sc.next();
		int index = 0;
		boolean found = true;
		
		for (int i = 0; i < recordCount; i++){
			if(records[i].getZipCode().equals(zipFind)){
				index = i;
				for(int j = index; j < recordCount; j++){
					records [j] = records[j+1];
				}
				
				System.out.println("Record with zip code number: "+ zipFind+" deleted.");
				records[recordCount-1]=null;
				recordCount--;
				found = true;
			}
			
			else {
				
				found = false;
					
				}
			}
		}
		

	// use PhoneRecord getName() method in conjunction with startsWith(String prefix) String method, see:
	// http://docs.oracle.com/javase/7/docs/api/java/lang/String.html#startsWith%28java.lang.String%29
	private static void findNumber() {
		// your code here
		
		System.out.print("Enter the name you want to find: ");
		String findName = sc.nextLine();
		
		for(int i = 0; i < recordCount;i++){
			if(records[i].getName().startsWith("s"))
				System.out.print(findName);
		}
		}	
	
	private static void displayRecordsWithSameLastName(){
		// your code here
		
		String name1 = null, name2 = null;
		
		for(int i = 0; i < recordCount; i++){
			if(records[i].getName().equals(name1) && name1 == name2)
				System.out.print(name1 + name2);
				
			
			
		}
		
	}

}

