package phoneBook;

import java.util.*;

public class PhoneBookMain {

static Scanner input;
static {
	input = new Scanner(System.in);
}
	
	public static void main(String[] args) {

Address a1 = new Address("114 Market St", "StLouis", "MO", 63403);
Person p1 = new Person("John", "Doe", 6366435698L, a1);



Address a2 = new Address("324 Main St", "StCharles", "MO", 63303);
Person p2 = new Person("John", "Doe", 8475390126L, a2);

Address address1 = new Address("574 Pole ave", "St.Peters", "MO", 63303);
Person person1 = new Person("John", "Doe", 5628592375L, address1);


DirectoryFunctions df1 = new DirectoryFunctions();

df1.addNumber(p1);
df1.addNumber(p2);
df1.addNumber(person1);

int customerChoice = 0;
while (customerChoice != 6) {
	customerChoice = menu();
	switch (customerChoice) {
	case 1:
		df1.addAContact();
		break;
	case 2:
		df1.deleteDirectory();
		System.out.println("Number deleted, returning to main menu...\n");
		break;
	case 3:
		df1.updateDirectory();
		break;
	case 4:
		df1.searchDirectory();
		break;
	case 5:
		System.out.println("**List of numbers in phone book**\n");
		df1.test();
		break;
	case 6:
		System.out.println("Application closing... Goodbye!");
		break;
	default:
		System.out.println("Please enter a number between 1 and 6.\n");
		break;
	
	}
}

}

public static int menu() {
	
Scanner scan1 = new Scanner(System.in);
System.out.println("****PHONE BOOK DIRECTORY****");
System.out.println("Enter 1 to add a number to the directory.");
System.out.println("Enter 2 to remove a number from the directory.");
System.out.println("Enter 3 to edit a record in the directory.");
System.out.println("Enter 4 to search the phone book.");
System.out.println("Enter 5 to view all numbers in the phone book.");
System.out.println("Enter 6 to close the directory.");

int customerChoice = scan1.nextInt();
System.out.println();
return customerChoice;

}
}