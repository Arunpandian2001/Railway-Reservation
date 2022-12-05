package storage;

import java.util.LinkedHashMap;
import java.util.Map;

import customexception.CustomException;
import data.Ticket;
import data.User;
import fileinterface.PersistentLayerPathway;
import fileloaddriver.FileDriver;

public enum Storage {

	VALUES();
	Map<Integer,Ticket> reservaitonDetails=new LinkedHashMap<>();
	Map<Integer,User> userDetails=new LinkedHashMap<>();
	int pnrNumber;

	PersistentLayerPathway details=new FileDriver();
	
	public int getPnrNumber() {
		return pnrNumber;
	}
	public Map<Integer, Ticket> getReservaitoDetails() {
		return reservaitonDetails;
	}
	public Map<Integer, User> getUserDetails() {
		return userDetails;
	}
	public void setPnrNumber() throws CustomException {
		this.pnrNumber =details.getPNRNumber();
	}
	public void setReservaitoDetails() throws CustomException {
		this.reservaitonDetails =details.getBookingDetails() ;
	}
	public void setUserDetails() throws CustomException {
		this.userDetails = details.getUserDetails();
	}
	public void updatePnrNumber(int number) throws CustomException {
		details.setPNRNumber(number);
		this.pnrNumber =number;
	}
	public void updateReservaitonDetails(Map<Integer, Ticket> map) throws CustomException {
		details.saveBookingDetails(map);
		this.reservaitonDetails=map;
	}
	public void updateUserDetails(Map<Integer, User> map) throws CustomException {
		details.saveUserDetails(map);
		this.userDetails=map;
		
	}
	public void loadValues() throws CustomException {
		setReservaitoDetails();
		setUserDetails();
		setPnrNumber();
	}
	
	public void updateValues() throws CustomException {
		updatePnrNumber(this.pnrNumber);
		updateUserDetails(this.userDetails);
		updateReservaitonDetails(this.reservaitonDetails);
	}
}
