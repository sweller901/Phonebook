package phoneBook;

import java.awt.Menu;
import java.text.Collator;
import java.util.*;
import java.util.stream.Stream;

public class DirectoryFunctions {

	static Scanner input;
	static {
		input = new Scanner(System.in);
	}

//array for numbers
	Person[] personDirectory = new Person[0];
	Address[] addressDirectory = new Address[0];
	Person content = new Person();

	public void test() {
		for (int i = 0; i < personDirectory.length; i++) {
			personDirectory[i].getCustomer();
			System.out.println("\n--------------------\n");
		}
		System.out.println("Returning to main menu...\n");
	}
	// ---------------------------------------------------------------

	// add number to array
	public void addNumber(Person newPerson) {

		Person[] tempArray = new Person[personDirectory.length + 1];

		// add person to the array
		for (int i = 0; i < personDirectory.length; i++) {
			tempArray[i] = personDirectory[i];
		}

		// add customer to the end of the temp array
		tempArray[tempArray.length - 1] = newPerson;

		// reset original array to the temp array;
		personDirectory = tempArray;

	}

	public void printDirectory(Person[] para) {
		for (int i = 0; i < para.length; i++) {
			para[i].getCustomer();
		}
	}
	public void printAddDirectory(Address[] para1) {
		for (int i = 0; i< para1.length; i++) {
			para1[i].toString();
		}
	}
	// -----------------------------------------------------------------

	public void addAContact() {
		Person person1 = new Person();

		System.out.println("Follow the instructions to add a person.");
		System.out.println("Enter first name:");
		person1.setFirstName(input.next());
		System.out.println("Enter last name:");
		person1.setLastName(input.next());
		System.out.println("Enter phone number (digits only):");
		person1.setPhoneNumber(input.nextLong());
		System.out.println();
		// String street, String city, String state, int zipCode
		System.out.println("Enter street:");
		String addStreet = input.next();

		System.out.println("Enter city:");
		String addCity = input.next();
		System.out.println();
		System.out.println("Enter state:");
		String addState = input.next();
		System.out.println();
		System.out.println("Enter zip code:");
		int addzipCode = input.nextInt();

		person1.addAddress(addStreet, addCity, addState, addzipCode);

		addNumber(person1);

		System.out.println("\nContact added to phonebook:\n");
		person1.getCustomer(); 
		System.out.print("Returning to main menu...");
		System.out.println("\n");
	}
	// ------------------------------------------------------------

	public void addAddress(Address newAddress) {

		Address[] tempArray1 = new Address[addressDirectory.length + 1];

		for (int i = 0; i < addressDirectory.length; i++) {
			tempArray1[i] = addressDirectory[i];
		}
		tempArray1[tempArray1.length - 1] = newAddress;

		addressDirectory = tempArray1;
	}

	public Person[] getDirectory() {
		return personDirectory;
	}

	// -----------------------------------------------------

	public void searchDirectory() {
		int input = 0;
		while (input != 7) {
			input = searchMenu();
			switch (input) {
			case 1:
				printDirectory(searchFirstName());
				break;
			case 2:
				printDirectory(searchLastName());
				break;
			case 3:
				printDirectory(searchFullName());
				break;
			case 4:
				printDirectory(searchTeleNum());
				break;
			case 5:
				printDirectory(searchCity());
				break;
			case 6:
				printDirectory(searchState());
				break;
			case 7:
				System.out.println("Search function closing.\n");
				break;
			default:
				System.out.println("\nSelect option 1-6 to continue\n");
			}
		}
	}

	// --------------------------------------------------

	public static int searchMenu() {

		System.out.println("Enter 1 to search by first name:");
		System.out.println("Enter 2 to search by last name:");
		System.out.println("Enter 3 to search by full name:");
		System.out.println("Enter 4 to search by telephone number:");
		System.out.println("Enter 5 to search by city:");
		System.out.println("Enter 6 to search by state:");
		System.out.println("Enter 7 to close search function and return to main menu.");
		int choice = input.nextInt();
		return choice;
	}
	// ---------------------------------------------------------------------

//	Person[] personDirectory = new Person[0];
//	Address[] addressDirectory = new Address[0];
//	Person content = new Person();

	public Person[] searchFirstName() {
		System.out.println("Enter first name");
		// seperate scanner
		String sfn = input.next();
		PhoneBookMain main = new PhoneBookMain();

		int count = 0;
		for (int i = 0; i < personDirectory.length; i++) {
			if (personDirectory[i].getFirstName().equals(sfn)) {
				count++;
			}
		}

		Person[] newArray = new Person[count];
		int x = 0;
		for (int i = 0; i < personDirectory.length; i++) {
			if (personDirectory[i].getFirstName().equals(sfn)) {
				newArray[x] = personDirectory[i];
				x++;
			}

		}
		return newArray;
	}

	// -----------------------------------------------------------------

	public Person[] searchLastName() {
		System.out.println("Enter last name");
		String sfn = input.next();
		PhoneBookMain main = new PhoneBookMain();

		int count = 0;
		for (int i = 0; i < personDirectory.length; i++) {
			if (personDirectory[i].getLastName().equals(sfn)) {
				count++;
			}
		}

		Person[] newArray = new Person[count];
		int x = 0;
		for (int i = 0; i < personDirectory.length; i++) {
			if (personDirectory[i].getLastName().equals(sfn)) {
				newArray[x] = personDirectory[i];
				x++;
			}
		}
		return newArray;
	}

	// ------------------------------------------------------
	
	public Person[] searchFullName() {
		System.out.println("Enter full name in this format: First,Last (and force 'close')");
		String sfn = input.next();
		String[] arrOfStr = sfn.split(",");
		PhoneBookMain main = new PhoneBookMain();
		
		

		int count = 0;
        for (int y = 0; y < arrOfStr.length; y++) {
		for (int i = 0; i < personDirectory.length; i++) {
			if (personDirectory[i].getFirstName().equals(arrOfStr[0]) && personDirectory[i].getLastName().equals(arrOfStr[1])) {
				count++;
			}
		}}

		Person[] newArray = new Person[count];
		int x = 0;
		for (int i = 0; i < personDirectory.length; i++) {
			if (personDirectory[i].getFirstName().equals(arrOfStr[0]) && personDirectory[i].getLastName().equals(arrOfStr[1])) {
				newArray[x] = personDirectory[i];
				x++;
			}

		}
		return newArray;
	}

	// ------------------------------------------------------------------

	public Person[] searchTeleNum() {
		System.out.println("Enter tele num");
		long sfn = input.nextLong();
		PhoneBookMain main = new PhoneBookMain();

		int count = 0;
		for (int i = 0; i < personDirectory.length; i++) {
			if (personDirectory[i].getPhoneNumber() == (sfn)) {
				count++;
			}
		}

		Person[] newArray = new Person[count];
		int x = 0;
		for (int i = 0; i < personDirectory.length; i++) {
			if (personDirectory[i].getPhoneNumber() == (sfn)) {
				newArray[x] = personDirectory[i];
				x++;
			}

		}
		return newArray;
	}
//------------------------------------------------
	public Person[] searchCity() {
		System.out.println("Enter city with no spaces");
		String sfn = input.next();
		PhoneBookMain main = new PhoneBookMain();
		
		int count = 0;
		for (int i = 0; i < personDirectory.length; i++) {
			if (personDirectory[i].getAddress().getCity().equals(sfn)) {
				count++;
			}
		}

		Person[] newArray = new Person[count];
		int x = 0;
		for (int i = 0; i < personDirectory.length; i++) {
			if (personDirectory[i].getAddress().getCity().equals(sfn)) {
				newArray[x] = personDirectory[i];
				x++;
			}

		}
		return newArray;
	}
	//------------------------------------

	public Person[] searchState() {
		System.out.println("Enter state");
		String sfn = input.next();
		PhoneBookMain main = new PhoneBookMain();
		
		int count = 0;
		for (int i = 0; i < personDirectory.length; i++) {
			if (personDirectory[i].getAddress().getState().equals(sfn)) {
				count++;
			}
		}

		Person[] newArray = new Person[count];
		int x = 0;
		for (int i = 0; i < personDirectory.length; i++) {
			if (personDirectory[i].getAddress().getState().equals(sfn)) {
				newArray[x] = personDirectory[i];
				x++;
			}

		}
		return newArray;
	}
	// ----------------------------------------------

//	// remove a contact
	public void deleteDirectory() {
		System.out.println("Please enter the phone number you would like to delete:");
		long sfn = input.nextLong();

		int count = 0;
		int index = -1;
		for (int i = 0; i < personDirectory.length; i++) {
			if (personDirectory[i].getPhoneNumber() == (sfn)) {
				index = count;
			}
			count++;
		}
		
	
		Person[] newArray = new Person[count];
		int x = 0;
		for (int i = 0; i < personDirectory.length; i++) {
			if(index == -1) {
				System.out.println("Number does not exist");
				break;
			}
			System.out.println(index);
			if (personDirectory[i].getPhoneNumber() == (sfn)) {
				for(int j = i; j < personDirectory.length - 1; j++) {
					personDirectory[j] = personDirectory[j + 1];
				}System.out.println(personDirectory.length);
				break;
			}
		}
	}


	public void updateDirectory() {
		System.out.println("Please Enter a Phone number to search for entry to update:");
		long sfn = input.nextLong();
		int index = -1;
		int count = 0;
		for (int i = 0; i < personDirectory.length; i++) {
			if (personDirectory[i].getPhoneNumber() == (sfn)) {
				index = count;
			}
			count++;
		}
		
		
		int choice = 0;
		System.out.println("What record would you like to update?");
		
		while (choice != 8) {
			System.out.println("Enter 1 to update first name:");
			System.out.println("Enter 2 to update last name:");
			System.out.println("Enter 3 to update tele number:");
			System.out.println("Enter 4 to update street:");
			System.out.println("Enter 5 to update city:");
			System.out.println("Enter 6 to update state:");
			System.out.println("Enter 7 to update zip code:");
			System.out.println("Enter 8 to close function and return to main menu.");
			choice = input.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("Please enter the new first name");
				personDirectory[index].setFirstName(input.next());
				System.out.println("First name updated.");
				System.out.println("Returning to edit screen...\n");
				break;
			case 2:
				System.out.println("Please enter the new last name");
				personDirectory[index].setLastName(input.next());
				System.out.println("Last name updated.");
				System.out.println("Returning to edit screen...\n");
				break;
			case 3:
				System.out.println("Please enter the new phone number");
				personDirectory[index].setPhoneNumber(input.nextLong());
				System.out.println("Phone number updated.");
				System.out.println("Returning to edit screen...\n");
				break;
			case 4:
				System.out.println("Please enter the new street");
				personDirectory[index].getAddress().setStreet(input.next());
				System.out.println("Street updated.");
				System.out.println("Returning to edit screen...\n");
				break;
			case 5:
				System.out.println("Please enter the new city with no space");
				personDirectory[index].getAddress().setCity(input.next());
				System.out.println("City updated.");
				System.out.println("Returning to edit screen...\n");
				break;
			case 6:
				System.out.println("Please enter the new state");
				personDirectory[index].getAddress().setState(input.next());
				System.out.println("State updated.");
				System.out.println("Returning to edit screen...\n");
				break;
			case 7:
				System.out.println("Please enter the new zip code");
				personDirectory[index].getAddress().setZipCode(input.nextInt());
				System.out.println("Zip code updated.");
				System.out.println("Returning to edit screen...\n");
				break;
			case 8:
				System.out.println("Update function closing.");
				System.out.println("Returning to main menu...\n");
				break;
			default:
				System.out.println("\nSelect option 1-8 to continue\n");
			}
		}
	}
}
