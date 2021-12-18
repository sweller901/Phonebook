package phoneBook;

import java.util.*;

public class Address {

private String street;
private String city;
private String state;
private int zipCode;

//what does this mean??
public Address() {}

public Address(String street, String city, String state, int zipCode) {
	this.street = street;
	this.city = city;
	this.state = state;
	this.zipCode = zipCode;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getStreet() {
	return street;
}

public void setStreet(String street) {
	this.street = street;
}

public long getZipCode() {
	return zipCode;
}

public void setZipCode(int zipCode) {
	this.zipCode = zipCode;
}

@Override
public String toString() {
	return "\nStreet Name: " + street + "\nCity: " + city + "\nState: " + state + "\nZip: " + zipCode;
}

}
