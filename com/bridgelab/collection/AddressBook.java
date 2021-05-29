package com.bridgelab.collection;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
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
	public String fname, lname, address, city, state, pin, mobileNo, mailId;
	ArrayList<AddressBookData> addressDataTest = new ArrayList<>();
	String str;
	Scanner sc = new Scanner(System.in);
	ArrayList<AddressBookData> changeValue = new ArrayList<>();

	public AdressBookTest(ArrayList<AddressBookData> addressDataTest) {
		super();
		this.addressDataTest = addressDataTest;
	}

	public AddressBookData dataEnteyInAddressBook() {
		System.out.println("Enter First Name");
		fname = sc.next();
		System.out.println("Enter Last Name");
		lname = sc.next();
		System.out.println("Enter Address Name");
		address = sc.next();
		System.out.println("Enter City Name");
		city = sc.next();
		System.out.println("Enter State Name");
		state = sc.next();
		System.out.println("Enter Pin Name");
		pin = sc.next();
		System.out.println("Enter MobileNo Name");
		mobileNo = sc.next();
		System.out.println("Enter MailId Name");
		mailId = sc.next();
		AddressBookData data = new AddressBookData(fname, lname, address, city, state, pin, mobileNo, mailId);
		return data;
	}

	public ArrayList<AddressBookData> chngeByName(ArrayList<AddressBookData> addressList) {
		System.out.println("Enter Name to Match from adress book and Change::");
		str = sc.next();
		for (AddressBookData value : addressList) {
			String listName = value.getFirstName();
			if (str.equalsIgnoreCase(listName)) {
				System.out.println("Data Found See list and change Value in list::" + value);
				AddressBookData data = dataEnteyInAddressBook();
				changeValue.add(data);
			} else {
				changeValue.add(value);
			}
		}
		return changeValue;
	}

	public ArrayList<AddressBookData> deleteByName(ArrayList<AddressBookData> addressList) {
		System.out.println("Enter a Name of Person to delete a Data");
		str = sc.next();
		for (AddressBookData value : addressList) {
			String listName = value.getFirstName();
			if (str.equalsIgnoreCase(listName)) {
				changeValue.add(value);
			}
		}
		addressList.removeAll(changeValue);
		changeValue.clear();
		changeValue.addAll(addressList);
		return changeValue;
	}

	public ArrayList<AddressBookData> addMultipleDataInAddressBook() {
		System.out.println("Enter Number How many Timme You Want to Insert Data In AddressBook");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			AddressBookData data = dataEnteyInAddressBook();
			changeValue.add(data);
		}
		return changeValue;
	}
}

public class AddressBook {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program Using Collection::");
		Scanner sc = new Scanner(System.in);
		AddressBookData data = new AddressBookData("Amit", "yadav", "Chembur", "Mumbai", "Maharashtra", "400074",
				"86555580069", "amit@gmail.com");
		ArrayList<AddressBookData> addressList = new ArrayList<>();
		AdressBookTest addTest = new AdressBookTest(addressList);
		ArrayList<AddressBookData> deleteList = new ArrayList<>();
		ArrayList<AddressBookData> changeList = new ArrayList<>();

		addressList.add(data);
		for (AddressBookData value : addressList) {
			System.out.println("Data Store In AddressBok::" + value);
		}
		
		
		System.out.println("Refactor Code::");
		Map<String, ArrayList<AddressBookData>> addressMap = new HashMap<>();
		System.out.println("Enter How many Entry you want in AddressBool::");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Give Unique Name To AddressBook::");
			String key = sc.next();
			AddressBookData refactorData = addTest.dataEnteyInAddressBook();
			changeList.add(refactorData);
			addressMap.put(key, changeList);
		}
		for (Entry<String, ArrayList<AddressBookData>> entry : addressMap.entrySet()) {
			System.out.println("Every Address Book Have  Specific Name Refactor Code::" + entry.getKey() + " Key&Value "
					+ entry.getValue());
		}

		addressList = addTest.addMultipleDataInAddressBook();
		System.out.println("Multple Value Output::" + addressList);
		for (AddressBookData value : addressList) {
			System.out.println("Data Store In AddressBok::" + value);
		}

		changeList = addTest.chngeByName(addressList);
		for (AddressBookData value : changeList) {
			System.out.println("After Change By Name In AddressBok::" + value);
		}

		deleteList = addTest.deleteByName(addressList);
		System.out.println("deleteList::" + deleteList);
		for (AddressBookData value : deleteList) {
			System.out.println("After Delete Data By Name In AddressBok::" + value);
		}

	}
}
