package com.bridgelab.collection;

import java.util.ArrayList;
import java.util.Scanner;

class AddressBookData {
	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	String zipCode;
	String phoneNumber;
	String email;

	public AddressBookData(String firstName, String lastName, String address, String city, String state, String zipCode,
			String phoneNumber, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "AddressBookData [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city="
				+ city + ", state=" + state + ", zipCode=" + zipCode + ", phoneNumber=" + phoneNumber + ", email="
				+ email + "]";
	}
}

class AdressBookTest {
	ArrayList<AddressBookData> addressDataTest = new ArrayList<>();

	public AdressBookTest(ArrayList<AddressBookData> addressDataTest) {
		super();
		this.addressDataTest = addressDataTest;
	}

	public ArrayList<AddressBookData> chngeByName(ArrayList<AddressBookData> addressList) {
		String str;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name to Match from adress book and Change::");
		str = sc.next();
		ArrayList<AddressBookData> changeValue = new ArrayList<>();
		for (AddressBookData value : addressList) {
			String listName = value.getFirstName();
			if (str.equalsIgnoreCase(listName)) {
				System.out.println("Data Found See list and change Value in list::" + value);
				String fname,lname,address,city,state,pin,mobileNo,mailId;
				System.out.println("Enter First Name");
				fname=sc.next();
				System.out.println("Enter Last Name");
				lname=sc.next();
				System.out.println("Enter Address Name");
				address=sc.next();
				System.out.println("Enter City Name");
				city=sc.next();
				System.out.println("Enter State Name");
				state=sc.next();
				System.out.println("Enter Pin Name");
				pin=sc.next();
				System.out.println("Enter MobileNo Name");
				mobileNo=sc.next();
				System.out.println("Enter MailId Name");
				mailId=sc.next();
				AddressBookData data = new AddressBookData(fname,lname,address,city,state,pin,mobileNo,mailId);
				changeValue.add(data);
			} else {
				changeValue.add(value);
			}
		}		
		return changeValue;
	}
}

public class AddressBook {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program Using Collection::");
		AddressBookData data = new AddressBookData("Amit", "yadav", "Chembur", "Mumbai", "Maharashtra", "400074",
				"86555580069", "amit@gmail.com");
		AddressBookData data1 = new AddressBookData("Vijay", "sing", "kurla", "Mumbai", "Maharashtra", "400024",
				"86555580089", "vijay@gmail.com");
		AddressBookData data2 = new AddressBookData("Naresh", "gupta", "Thane", "Mumbai", "Maharashtra", "400004",
				"86557880089", "naresh@gmail.com");

		ArrayList<AddressBookData> changeList = new ArrayList<>();
		ArrayList<AddressBookData> addressList = new ArrayList<>();
		addressList.add(data);
		addressList.add(data1);
		addressList.add(data2);
		for (AddressBookData value : addressList) {
			System.out.println("Data Store In AddressBok::" + value);
		}

		AdressBookTest addTest = new AdressBookTest(addressList);
		changeList = addTest.chngeByName(addressList);
		for (AddressBookData value : changeList) {
			System.out.println("After Change By Name In AddressBok::" + value);
		}

	}
}
