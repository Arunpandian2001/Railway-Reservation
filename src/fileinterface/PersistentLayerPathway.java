package fileinterface;

import java.util.Map;

import customexception.CustomException;
import data.Ticket;
import data.User;

public interface PersistentLayerPathway {

	void saveUserDetails(User user,Map<Integer,String> userDetails) throws CustomException ;
	
	void saveBookingDetails(Map<Integer,Ticket> bookingDetails) throws CustomException;
	
	Map<Integer, User> getUserDetails() throws CustomException;
	Map<Integer, Ticket> getBookingDetails() throws CustomException;
}
