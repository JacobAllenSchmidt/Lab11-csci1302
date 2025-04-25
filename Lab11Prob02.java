import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
* File: Lab11Prob02.java
* Class: CSCI 1302
* Author: Jacob Schmidt
* Created on: Apr 25, 2025
* Last Modified: Apr 25, 2025
* Description: 
*/

public class Lab11Prob02 {

	public static void main(String[] args) {
		
		try (
				DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"));
				DataOutputStream output = new DataOutputStream(new FileOutputStream("people-copy.dat"));
			) {
			
			// Variables to hold read values
			int age, zipCode;
			String fullName, address;
			double salary;
			
			
			while (true) {
				// Read values
				age = input.readInt();
				fullName = input.readUTF();
				address = input.readUTF();
				zipCode = input.readInt();
				salary = input.readDouble();
				
				// Output to console
				System.out.printf("%d %s %s %d %.2f%n", age, fullName, address, zipCode, salary);
				
				// Output to file
				output.writeInt(age);
				output.writeUTF(fullName);
				output.writeUTF(address);
				output.writeInt(zipCode);
				output.writeDouble(salary);
			}
			
		} catch (FileNotFoundException ex) {
			//ex.printStackTrace();
		} catch (EOFException ex) {
			//ex.printStackTrace();
		} catch (IOException ex) {
			//ex.printStackTrace();
		}
	}
}

class Person {
	private int age, zipCode;
	private String fullName, address;
	private double salary;
	
	public Person() {
		age = 1;
		zipCode = 11111;
		fullName = "Tralalero Tralala";
		address = "123 Sesame Street";
		salary = 69.0;
	}
	
	@Override
	public String toString() {
		return String.format("%d %s %s %d %.2f%n", age, fullName, address, zipCode, salary);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}