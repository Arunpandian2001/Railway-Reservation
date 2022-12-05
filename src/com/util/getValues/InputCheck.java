package com.util.getValues;

import java.util.Scanner;

import customexception.CustomException;


public class InputCheck {

	private Scanner input=new Scanner(System.in);
	
	public int isInteger() throws CustomException {
		boolean loop=true;
		int number=0;
		while(loop) {
			if(input.hasNextInt()) {
				number=input.nextInt();
				loop=false;
			}
			else {
				input.next();
				throw new CustomException("Enter only integer type");
			}
		}
		return number;
	}

	public String getString() {
		String name = null;
		name=input.next();
		input.nextLine();
		return name;
	}
	
	public double isDouble() throws CustomException {

		boolean loop=true;
		double number=0;
		while(loop) {
			if(input.hasNextDouble()) {
				number=input.nextDouble();
				loop=false;
			}
			else {
				input.next();
				throw new CustomException("Enter only double type");
			}
		}
		return number;

	}
	
	public long isLong() throws CustomException {
		boolean loop=true;
		long number=0;
		while(loop) {
			if(input.hasNextLong()) {
				number=input.nextInt();
				loop=false;
			}
			else {
				input.next();
				throw new CustomException("Enter only long type");
			}
		}
		return number;

	}

	public boolean isBoolean() throws CustomException {
		boolean value = false;
		boolean loop=true;
		while(loop) {
			if(input.hasNextBoolean()) {
				value=input.nextBoolean();
				loop=false;
			}
			else {
				input.next();
				throw new CustomException("Enter only boolean type");
			}
		}
		return value;
	}
	
	public float isFloat() throws CustomException {
		boolean loop=true;
		float number=0;
		while(loop) {
			if(input.hasNextFloat()) {
				number=input.nextFloat();
				loop=false;
			}
			else {
				input.next();
				throw new CustomException("Enter only float type");
			}
		}
		return number;
	}

	public void close() {
		input.close();
	}
}
