package fileinterface;

import java.util.Map;

import customexception.CustomException;
import data.Ticket;
import data.User;

public interface PersistentLayerPathway {

	void saveUserDetails(Map<Integer,User> userDetails) throws CustomException ;
	
	void saveBookingDetails(Map<Integer,Ticket> bookingDetails) throws CustomException;
	
	void setPNRNumber(int pnrNumber) throws CustomException;

	
	Map<Integer, User> getUserDetails() throws CustomException;
	Map<Integer, Ticket> getBookingDetails() throws CustomException;
	
	int getPNRNumber() throws CustomException;

}
