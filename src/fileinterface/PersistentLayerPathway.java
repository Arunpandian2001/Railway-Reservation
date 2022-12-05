package fileinterface;

import java.util.List;
import java.util.Map;

import customexception.CustomException;
import data.Passenger;
import data.Ticket;
import data.User;

public interface PersistentLayerPathway {

	void saveUserDetails(Map<Integer,User> userDetails) throws CustomException ;
	
	void saveBookingDetails(Map<Integer,Ticket> bookingDetails) throws CustomException;
	
	void saveRACDetails(List<Passenger> list) throws CustomException;
	
	void setPNRNumber(int pnrNumber) throws CustomException;

	List<Passenger> getRACDetails() throws CustomException;
	
	Map<Integer, User> getUserDetails() throws CustomException;
	
	Map<Integer, Ticket> getBookingDetails() throws CustomException;
	
	int getPNRNumber() throws CustomException;

}
