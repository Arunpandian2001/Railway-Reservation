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
	
	PersistentLayerPathway details=new FileDriver();
	
	public Map<Integer, Ticket> getReservaitoDetails() {
		return reservaitonDetails;
	}
	public void setReservaitoDetails() {
		this.reservaitonDetails = null;
	}
	public Map<Integer, User> getUserDetails() {
		return userDetails;
	}
	public void setUserDetails() throws CustomException {
		this.userDetails = details.getUserDetails();
	}
	
	public void updateReservaitonDetails(Map<Integer, Ticket> map) {
		this.reservaitonDetails=map;
	}
	
	public void updateUserDetails(Map<Integer, User> map) {
		this.userDetails=map;
	}
	
	public void loadValues() throws CustomException {
		setReservaitoDetails();
		setUserDetails();
	}
	
}
