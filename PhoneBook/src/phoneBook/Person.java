package phoneBook;

import java.util.*;

public class Person {

private String firstName;
private String lastName;
private long phoneNumber;
private Address address;

//what is this??
public Person() {}

public Person(String firstName, String lastName, long phoneNumber, Address address) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.phoneNumber = phoneNumber;
	this.address = address;
}

public void addAddress(String street, String city, String state, int zipCode) {
	Address tempAddress = new Address(street, city, state, zipCode);
	address = tempAddress;

}

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public long getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(long phoneNumber) {
	this.phoneNumber = phoneNumber;
}


public void getCustomer() {
	System.out.println("First Name: " + firstName + "\nLast Name: " + lastName + "\nPhone Number: " + phoneNumber + "\nAddress: " + address);
}




}
